package com.example.backendrest.base.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // İstek başlangıç zamanını kaydet
        long startTime = System.currentTimeMillis();

        // İsteği işle
        chain.doFilter(request, response);

        // İstek süresini hesapla
        long duration = System.currentTimeMillis() - startTime;

        // İstek süresi ve detayları ile ilgili bilgileri logla
        LOGGER.info("{} {} took {} ms", httpRequest.getMethod(), httpRequest.getRequestURI(), duration);
    }

}
