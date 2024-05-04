package com.example.springbootassignment.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${app.clientId}")
    private String validClientId;

    @Value("${app.clientSecret}")
    private String validClientSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String clientId = request.getHeader("client-id");
        String clientSecret = request.getHeader("client-secret");

        if (clientId == null || clientSecret == null || !clientId.equals(validClientId)
                || !clientSecret.equals(validClientSecret)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            String errorMessage = "Unauthorized: Invalid client credentials";
            // Convert error message to JSON
            String jsonResponse = "{\"error\": \"" + errorMessage + "\"}";
            // Set response content type to JSON
            response.setContentType("application/json");
            // Write JSON response to the output stream
            response.getWriter().write(jsonResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Do nothing or add post-processing logic if needed
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // Do nothing or add after completion logic if needed
    }
}
