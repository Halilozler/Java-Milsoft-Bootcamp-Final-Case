package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;

public interface AuthService {
    BaseResponse<Integer> GetBasketCount(long userId);
}
