package com.sch.chekirout.auth.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.chekirout.common.exception.CustomAuthenticationException;
import com.sch.chekirout.global.presentation.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        Throwable cause = authException.getCause();

        if (cause instanceof CustomAuthenticationException) {
            CustomAuthenticationException customException = (CustomAuthenticationException) cause;

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json;charset=UTF-8");

            ErrorResponse errorResponse = new ErrorResponse(
                    customException.getMessage(),
                    customException.getErrorCode(),
                    HttpStatus.BAD_REQUEST.value()
            );

            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        }
    }
}