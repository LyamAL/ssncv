package com.zaq.ssncv.ssncvprovideruser.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Authority;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser.service.BaseService;
import com.zaq.ssncv.ssncvprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_PHONE;
import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_USERNAME;

/**
 * @author ZAQ
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    private static final String CONSTRAINT_UNIQUE_KEY_PHONE = "user_phone_uindex";
    private static final String CONSTRAINT_UNIQUE_KEY_USERNAME = "user_username_uindex";

    private static final String VALUE_DUPLICATE_PHONE = "duplicate phone";
    private static final String VALUE_DUPLICATE_USERNAME = "duplicate username";
    private static final String VALUE_UNKNOWN_CAUSE = "unknown failure";
    private final static String REG_PHONE = "[0-9]{7}[0-9]*$";
    private static final String BAD_CREDENTIAL = "wrong password";
    private UserDao userDao;
    private SessionRegistry sessionRegistry;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(@Autowired UserDao userDao,
                           @Autowired SessionRegistry sessionRegistry, @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.sessionRegistry = sessionRegistry;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Result<String> delete(int id) {
        int callback = userDao.delete(id);
        Result<String> result = new Result<>();
        wrapResponse(result, callback);
        return result;
    }

    @Override
    public Result<String> update(UserOnModify user) {
        Result<String> result = new Result<>();
        user.setNewPsw(bCryptPasswordEncoder.encode(user.getNewPsw()));
        wrapResponse(result, userDao.update(user));
        return result;
    }

    @Override
    public Result<String> updateSelectively(User user) {
        Result<String> result = new Result<>();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        wrapResponse(result, userDao.updateSelectively(user));
        return result;
    }

    @Override
    @Transactional(rollbackFor = DuplicateKeyException.class)
    public Result<User> register(User user) {
        int res = 0;
        String msg = null;
        String psw = user.getPassword();
        psw = bCryptPasswordEncoder.encode(psw);
        user.setPassword(psw);
        try {
            res = userDao.insert(user);
            userDao.insertRole(user.getId());
        } catch (DuplicateKeyException e) {
            if (Objects.requireNonNull(e.getMessage()).contains(CONSTRAINT_UNIQUE_KEY_PHONE)) {
                res = KEY_DUPLICATE_PHONE;
                msg = VALUE_DUPLICATE_PHONE;
            } else if (e.getMessage().contains(CONSTRAINT_UNIQUE_KEY_USERNAME)) {
                res = KEY_DUPLICATE_USERNAME;
                msg = VALUE_DUPLICATE_USERNAME;
            } else {
                msg = VALUE_UNKNOWN_CAUSE;
            }
        }
        Result<User> result = new Result<>();
        wrapResponse(result, res, msg);
        user.setRoles(new ArrayList<String>() {{
            add(Authority.USER.toString());
        }});
        result.setData(user);
        return result;
    }

    @Override
    public Result<User> findById(int id) {
        Result<User> result = new Result<>();
        User user = userDao.findById(id);
        wrapResponse(result, user);
        return result;
    }

    @Override
    public Result<List<User>> queryAll() {
        Result<List<User>> result = new Result<>();
        List<User> users = userDao.queryAll();
        wrapResponse(result, users);
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUser(s);

//        List<GrantedAuthority> authorities = new ArrayList<>();
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

        }
        return user;
//        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), authorities);
    }

    private User findUser(String username) {
        if (username.matches(REG_PHONE)) {
            return userDao.selectByPhone(username);
        } else {
            return userDao.selectByName(username);
        }
    }

}
