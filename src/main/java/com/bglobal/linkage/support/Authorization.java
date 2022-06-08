package com.bglobal.linkage.support;

import javax.servlet.http.HttpServletRequest;

public class Authorization {
    public static Boolean checkToken(String token, HttpServletRequest request) {
        String authToken = request.getSession().getAttribute("access_token").toString();
        if (authToken == null) {
            return false;
        }
        return token.equals(authToken);
    }
}
