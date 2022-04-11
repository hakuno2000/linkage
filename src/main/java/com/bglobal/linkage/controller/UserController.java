package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.ResponseLoginDTO;
import com.bglobal.linkage.entity.User;
import com.bglobal.linkage.service.UserService;
import com.bglobal.linkage.DTO.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO requestLoginDto) {
        User user = userService.login(requestLoginDto.getUsername(), requestLoginDto.getPassword());
        if (user == null) return ResponseEntity.status(401).build();
        ResponseLoginDTO responseLoginDto = new ResponseLoginDTO(user);
        return ResponseEntity.ok(responseLoginDto);
    }
}
