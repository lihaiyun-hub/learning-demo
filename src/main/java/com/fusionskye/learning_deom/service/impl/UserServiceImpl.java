package com.fusionskye.learning_deom.service.impl;

import com.fusionskye.learning_deom.mapper.ds1.UserMapper;
import com.fusionskye.learning_deom.po.User;
import com.fusionskye.learning_deom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LHY
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
