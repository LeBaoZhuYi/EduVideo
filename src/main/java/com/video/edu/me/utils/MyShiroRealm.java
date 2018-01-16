package com.video.edu.me.utils;


import java.util.HashSet;
import java.util.Set;

import com.video.edu.me.dao.UserMapper;
import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = principals.getPrimaryPrincipal().toString();
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(userName);
        RoleType roleType = RoleType.getById(userMapper.selectByExample(userExample).get(0).getRoleId());
        roleNames.add(roleType.getDesc());//添加角色
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {//获取用户账号
        String userName = authcToken.getPrincipal().toString() ;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(userName);
        User user = userMapper.selectByExample(userExample).get(0);

        if (user != null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),
                    "MyShiroRealm") ;
            return authenticationInfo ;
        }else{
            return  null ;
        }
    }

}
