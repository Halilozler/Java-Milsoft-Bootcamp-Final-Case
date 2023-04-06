package com.example.backendrest.base.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse<T> {
    //BaseResponse<String> response = BaseResponse.success("Hello, world!", 200);
    //BaseResponse<String> response = BaseResponse.success(400);
    public T data;
    @JsonIgnore
    private int statusCode;
    @JsonIgnore
    private boolean isSuccessful;
    private List<String> errors;
    //Static Factory Methodur.
    public static<T> BaseResponse<T> Success(T data, int statusCode)
    {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        response.setStatusCode(statusCode);
        response.setSuccessful(true);
        return response;
    }
    public static<T> BaseResponse<T> Success(int statusCode)
    {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(null); // In Java, use 'null' instead of 'default(T)'
        response.setStatusCode(statusCode);
        response.setSuccessful(false);
        return response;
    }

    public static <T> BaseResponse<T> fail(List<String> errors, int statusCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setErrors(errors);
        response.setStatusCode(statusCode);
        response.setSuccessful(false);
        return response;
    }
    //Çoklu Hata için
    public static <T> BaseResponse<T> fail(String error, int statusCode) {
        List<String> errors = new ArrayList<>();
        errors.add(error);
        return fail(errors, statusCode);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
