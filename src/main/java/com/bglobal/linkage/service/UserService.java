package com.bglobal.linkage.service;

import com.bglobal.linkage.entity.User;

public interface UserService {
    User login(String username, String password);
}
