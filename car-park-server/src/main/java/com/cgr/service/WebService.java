package com.cgr.service;


import com.cgr.ResponseModel;
import com.cgr.dto.LoginBody;

public interface WebService {
    ResponseModel login(LoginBody loginBody);
}
