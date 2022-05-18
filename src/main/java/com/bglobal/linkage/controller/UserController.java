package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.ESAuthorizeDTO;
import com.bglobal.linkage.DTO.LinkageResponseLoginDTO;
import com.bglobal.linkage.DTO.LinkageResponseTokenDTO;
import com.bglobal.linkage.entity.User;
import com.bglobal.linkage.service.LinkageService;
import com.bglobal.linkage.service.UserService;
import com.bglobal.linkage.DTO.ESLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LinkageService linkageService;

//    @GetMapping("")
//    public ResponseEntity<Object> testLogin() {
//        return ResponseEntity.ok(linkageService.loginToMPOS());
//    }
//
//    @GetMapping("auth")
//    public ResponseEntity<Object> testAuth() {
//        return ResponseEntity.ok(linkageService.authorizeMPOS());
//    }

    @PostMapping("auth/login")
    public ResponseEntity<Object> login(@RequestBody ESLoginDTO requestESLoginDto, HttpServletRequest request) {
        User user = userService.login(requestESLoginDto.getUsername(), requestESLoginDto.getPassword());
        if (user == null) return ResponseEntity.status(401).build();
        LinkageResponseLoginDTO linkageResponseLoginDto = new LinkageResponseLoginDTO(user);
        linkageResponseLoginDto.setSessionId(request.getSession().getId());
        return ResponseEntity.ok(linkageResponseLoginDto);
    }

    @PostMapping("provider/authorize")
    public ResponseEntity<Object> authorize(@RequestBody ESAuthorizeDTO ESAuthorizeDTO, HttpServletRequest request) {
        String clientId = ESAuthorizeDTO.getClientId();
        String clientSecret = ESAuthorizeDTO.getClientSecret();
        String authSessionId = ESAuthorizeDTO.getSessionId();
        String sessionId = request.getSession().getId();

        if (!authSessionId.equals(sessionId)) return ResponseEntity.status(401).build();
        LinkageResponseTokenDTO linkageResponseTokenDTO = new LinkageResponseTokenDTO();
        linkageResponseTokenDTO.setAccessToken(UUID.randomUUID().toString().replaceAll("-", "") + clientSecret);
        linkageResponseTokenDTO.setRefreshToken(UUID.randomUUID().toString().replaceAll("-", ""));

        Long currentTime = System.currentTimeMillis();
        currentTime /= 1000;
        Long expiredTime = currentTime + 1800;
        linkageResponseTokenDTO.setExpiredTime(expiredTime.toString());

        request.getSession().removeAttribute("access_token");
        request.getSession().removeAttribute("refresh_token");
        request.getSession().removeAttribute("expired_time");
        request.getSession().setAttribute("access_token", linkageResponseTokenDTO.getAccessToken());
        request.getSession().setAttribute("refresh_token", linkageResponseTokenDTO.getRefreshToken());
        request.getSession().setAttribute("expired_time", linkageResponseTokenDTO.getExpiredTime());

        return ResponseEntity.ok(linkageResponseTokenDTO);
    }

    @PostMapping("provider/token")
    public ResponseEntity<Object> refreshAuthorize(@RequestBody ESAuthorizeDTO ESAuthorizeDTO, HttpServletRequest request) {
        String refreshToken = ESAuthorizeDTO.getRefreshToken();

        if (!refreshToken.equals(request.getSession().getAttribute("refresh_token"))) return ResponseEntity.status(401).build();
        LinkageResponseTokenDTO linkageResponseTokenDTO = new LinkageResponseTokenDTO();
        linkageResponseTokenDTO.setRefreshToken(refreshToken);
        linkageResponseTokenDTO.setAccessToken(UUID.randomUUID().toString().replaceAll("-", "") + ESAuthorizeDTO.getClientSecret());

        Long currentTime = System.currentTimeMillis();
        currentTime /= 1000;
        Long expiredTime = currentTime + 1800;
        linkageResponseTokenDTO.setExpiredTime(expiredTime.toString());

        request.getSession().removeAttribute("access_token");
        request.getSession().removeAttribute("expired_time");
        request.getSession().setAttribute("access_token", linkageResponseTokenDTO.getAccessToken());
        request.getSession().setAttribute("expired_time", linkageResponseTokenDTO.getExpiredTime());

        return ResponseEntity.ok(linkageResponseTokenDTO);
    }
}
