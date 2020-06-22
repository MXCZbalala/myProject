package com.aaa.lu.springboot.realms;


import com.aaa.lu.springboot.model.User;
import com.aaa.lu.springboot.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


//AuthenticatingRealm :认证Realm
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    /**
     *
     * @param authenticationToken   从前端传过来的token 信息（用户名和密码）
     * @return  认证信息 ，从数据库中查出来的用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取前端的token
         UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

         //前端用户名
        String username = token.getUsername();

        //数据库中取到的用户对象
        User user = userService.findUserByName(username);

        if(user==null){
            throw new UnknownAccountException("账号不存在");
        }
        //其它异常

        //查询出 前端用户名 对应的数据库的用户名
        // 前端用户名 对应的数据库的密码 ，加密后的密码
        //ByteSource.Util.bytes(user.getUsername()):盐
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), this.getName());
        return info;
    }

    /**
     * 返回授权信息
     * @param principalCollection 登录后的身份集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录后的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名获取到对应的角色集合或者权限集合

       SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();

       //设置角色集合
        Set<String> roles=new HashSet<>();
        roles.add("管理员");
        roles.add("库管");
        roles.add("管理员2");
        //绑定角色
//       authorizationInfo.setRoles();
         //绑定权限集合
        authorizationInfo.setStringPermissions(userService.findPermissionsByName(username));

        return authorizationInfo;
    }
}
