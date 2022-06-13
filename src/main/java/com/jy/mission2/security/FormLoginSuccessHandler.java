package com.jy.mission2.security;

import com.jy.mission2.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) {
        System.out.println("FromLoginSuccessHandler");

        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());

        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        System.out.println(token);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);

    }
}
