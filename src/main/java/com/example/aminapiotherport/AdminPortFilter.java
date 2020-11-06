package com.example.aminapiotherport;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AdminPortFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UrlPathHelper x = new UrlPathHelper();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getRequestURI().startsWith("/adm/") == true && request.getLocalPort() != 9999) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
