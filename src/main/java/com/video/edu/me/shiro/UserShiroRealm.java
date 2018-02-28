package com.video.edu.me.shiro;


import com.video.edu.me.dao.UserMapper;
import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.enumeration.RoleType;
import com.video.edu.me.utils.EncryptUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserShiroRealm.class);
    @Autowired
    UserMapper userMapper;

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String userName = principals.getPrimaryPrincipal().toString();
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andLoginNameEqualTo(userName);
//        RoleType roleType = RoleType.getById(userMapper.selectByExample(userExample).get(0).getRoleId());
//        roleNames.add(roleType.getDesc());//添加角色
        roleNames.add(RoleType.USER.getDesc());//添加角色
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {//获取用户账号
        CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
        String loginName = customizedToken.getPrincipal().toString() ;
        String token = String.valueOf((char[])customizedToken.getCredentials());
        String [] pairs = token.split("[+]");
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName);
        List<User> users = userMapper.selectByExample(userExample);
        String realmName = getName();
        AuthenticationInfo authenticationInfo = null;
        if (users != null && users.size() > 0){
            User user = users.get(0);
            if (EncryptUtil.checkPassword(user.getPassword() + pairs[1], pairs[0])) {
                //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
                authenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(), token,
                        realmName);
                return authenticationInfo;
            } else{
                throw new AuthenticationException();
            }
        } else {
            throw new UnknownAccountException();
        }
    }
}
