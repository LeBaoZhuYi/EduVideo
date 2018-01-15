package com.video.edu.me.security;

import java.util.List;

import com.video.edu.me.common.RoleType;
import com.video.edu.me.dao.UserMapper;
import com.video.edu.me.entity.User;
import com.video.edu.me.entity.UserExample;
import com.video.edu.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
            // TODO Auto-generated method stub

            User user = null;
            try {
                UserExample userExample = new UserExample();
                UserExample.Criteria criteria = userExample.createCriteria();
                criteria.andLoginNameEqualTo(username);
                List<User> userList = userMapper.selectByExample(userExample);
                user = userList.get(0);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(user == null)
                throw new UsernameNotFoundException("user not found!");
            //roles=角色代码
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(RoleType.getById(user.getRoleId()).getDesc());
            org.springframework.security.core.userdetails.User userInfo = new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true, authorities);
            return userInfo;
    }
}