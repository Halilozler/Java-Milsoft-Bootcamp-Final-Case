package com.example.backendrest.business.service.abstracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
    UserDetails loadUserByUsername(String username);
}
