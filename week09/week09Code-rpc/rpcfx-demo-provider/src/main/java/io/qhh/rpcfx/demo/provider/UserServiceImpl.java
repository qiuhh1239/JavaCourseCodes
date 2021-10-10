package io.qhh.rpcfx.demo.provider;

import io.qhh.rpcfx.demo.api.User;
import io.qhh.rpcfx.demo.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
