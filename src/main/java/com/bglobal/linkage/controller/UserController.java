package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.AuthorizeDTO;
import com.bglobal.linkage.DTO.ResponseLoginDTO;
import com.bglobal.linkage.DTO.ResponseTokenDTO;
import com.bglobal.linkage.entity.User;
import com.bglobal.linkage.service.UserService;
import com.bglobal.linkage.DTO.LoginDTO;
import com.bglobal.linkage.support.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO requestLoginDto, HttpServletRequest request) {
        User user = userService.login(requestLoginDto.getUsername(), requestLoginDto.getPassword());
        if (user == null) return ResponseEntity.status(401).build();
        ResponseLoginDTO responseLoginDto = new ResponseLoginDTO(user);
        responseLoginDto.setSessionId(request.getSession().getId());
        return ResponseEntity.ok(responseLoginDto);
    }

    @PostMapping("provider/authorize")
    public ResponseEntity<Object> authorize(@RequestBody AuthorizeDTO authorizeDTO, HttpServletRequest request) {
        String clientId = authorizeDTO.getClientId();
        String clientSecret = authorizeDTO.getClientSecret();
        String authSessionId = authorizeDTO.getSessionId();
        String sessionId = request.getSession().getId();

        if (!authSessionId.equals(sessionId)) return ResponseEntity.status(401).build();
        ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO();
        responseTokenDTO.setAccessToken(UUID.randomUUID().toString().replaceAll("-", "") + clientSecret);
        responseTokenDTO.setRefreshToken(UUID.randomUUID().toString().replaceAll("-", ""));

        Long currentTime = System.currentTimeMillis();
        currentTime /= 1000;
        Long expiredTime = currentTime + 1800;
        responseTokenDTO.setExpiredTime(expiredTime.toString());

        request.getSession().removeAttribute("access_token");
        request.getSession().removeAttribute("refresh_token");
        request.getSession().removeAttribute("expired_time");
        request.getSession().setAttribute("access_token", responseTokenDTO.getAccessToken());
        request.getSession().setAttribute("refresh_token", responseTokenDTO.getRefreshToken());
        request.getSession().setAttribute("expired_time", responseTokenDTO.getExpiredTime());

        return ResponseEntity.ok(responseTokenDTO);
    }

    @PostMapping("provider/token")
    public ResponseEntity<Object> refreshAuthorize(@RequestBody AuthorizeDTO authorizeDTO, HttpServletRequest request) {
        String refreshToken = authorizeDTO.getRefreshToken();

        if (!refreshToken.equals(request.getSession().getAttribute("refresh_token"))) return ResponseEntity.status(401).build();
        ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO();
        responseTokenDTO.setRefreshToken(refreshToken);
        responseTokenDTO.setAccessToken(UUID.randomUUID().toString().replaceAll("-", "") + authorizeDTO.getClientSecret());

        Long currentTime = System.currentTimeMillis();
        currentTime /= 1000;
        Long expiredTime = currentTime + 1800;
        responseTokenDTO.setExpiredTime(expiredTime.toString());

        request.getSession().removeAttribute("access_token");
        request.getSession().removeAttribute("expired_time");
        request.getSession().setAttribute("access_token", responseTokenDTO.getAccessToken());
        request.getSession().setAttribute("expired_time", responseTokenDTO.getExpiredTime());

        return ResponseEntity.ok(responseTokenDTO);
    }
}
