package com.bglobal.linkage.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.bglobal.linkage.entity.User;
import com.bglobal.linkage.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User login(String username, String password) {
        User user = userRepo.findUserByUsername(username);
        if (user == null) return null;
//        String bcryptHashString = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToString(12, password.toCharArray());
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (result.verified)  return user;
        else return null;
    }
}
