package com.zaq.ssncv.ssncvprovideruser.service.impl;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_PHONE;
import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_USERNAME;

/**
 * @author ZAQ
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final String CONSTRAINT_UNIQUE_KEY_PHONE = "user_phone_uindex";
    private static final String CONSTRAINT_UNIQUE_KEY_USERNAME = "user_username_uindex";

    private static final String VALUE_DUPLICATE_PHONE = "duplicate phone";
    private static final String VALUE_DUPLICATE_USERNAME = "duplicate username";
    private static final String VALUE_UNKNOWN_CUASE = "unknown failure";
    private final static String REG_PHONE = "[0-9]{7}[0-9]*$";
    private UserDao userDao;
    private SessionRegistry sessionRegistry;

    public UserServiceImpl(@Autowired UserDao userDao,
                           @Autowired SessionRegistry sessionRegistry) {
        this.userDao = userDao;
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int updateAfterAuth(UserOnModify user) {
        return userDao.updateWhenPswMatches(user);
    }

    @Override
    public int updateSelectively(User user) {
        return userDao.updateSelectively(user);
    }

    @Override
    @Transactional(rollbackFor = DuplicateKeyException.class)
    public int register(User user) {
        int res = 0;
        try {
            res = userDao.insert(user);
        } catch (DuplicateKeyException e) {
            if (e.getMessage().contains(CONSTRAINT_UNIQUE_KEY_PHONE)) {
                return KEY_DUPLICATE_PHONE;
            }
            if (e.getMessage().contains(CONSTRAINT_UNIQUE_KEY_USERNAME)) {
                return KEY_DUPLICATE_USERNAME;
            }
        }
        return res;
    }

    @Override
    public String getMessage(int status) {
        switch (status) {
            case KEY_DUPLICATE_PHONE:
                return VALUE_DUPLICATE_PHONE;
            case KEY_DUPLICATE_USERNAME:
                return VALUE_DUPLICATE_USERNAME;
            default:
                return VALUE_UNKNOWN_CUASE;
        }
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUser(s);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
            for (Object principal : allPrincipals) {
                if (principal instanceof UserDetails && (((UserDetails) principal).getUsername()
                        .equals(((User) principal).getUsername()))) {
                    throw new SessionAuthenticationException("当前用户已经在线，登录失败");
                }
            }
            for (GrantedAuthority authority : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
        }
        return user;
//        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),
//                user.getPassword(), authorities);

    }

    private User findUser(String username) {
        if (username.matches(REG_PHONE)) {
            return userDao.selectByPhone(username);
        } else {
            return userDao.selectByName(username);
        }
    }

}
