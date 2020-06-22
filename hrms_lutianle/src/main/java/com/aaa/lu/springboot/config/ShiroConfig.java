package com.aaa.lu.springboot.config;

import com.aaa.lu.springboot.realms.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //将方法返回的对象配置成bean
    @Bean   //配置安全管理器
    public SecurityManager securityManager(){     //2、将对象当成入参使用，自动注入
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //绑定Realm
        securityManager.setRealm(userRealm()); //1 调用方法userRealm()
//        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean  //配置数据域
    public UserRealm userRealm(){
          UserRealm userRealm=new UserRealm();
          //设置密码匹配器
          userRealm.setCredentialsMatcher(credentialsMatcher());
          return userRealm;
    }

    @Bean //密码匹配器
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(2);
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        LifecycleBeanPostProcessor postProcessor=new LifecycleBeanPostProcessor();
        return postProcessor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator autoProxyCreator(){
        DefaultAdvisorAutoProxyCreator proxyCreator=new DefaultAdvisorAutoProxyCreator();
        //启动cglib类代理
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor sourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        return advisor;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login.html");
        bean.setSuccessUrl("/index.html");
        bean.setUnauthorizedUrl("/error.html");

        //过滤的路径
        Map<String,String> map=new HashMap<>();
        map.put("/login", "anon");
        map.put("/static/**","anon");
        map.put("/dept/**", "authc");
        map.put("/logout", "logout");
        bean.setFilterChainDefinitionMap(map);

        return bean;

    }

}
