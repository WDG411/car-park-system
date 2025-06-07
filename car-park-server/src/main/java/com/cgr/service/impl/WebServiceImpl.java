package com.cgr.service.impl;


import com.cgr.ResponseModel;
import com.cgr.constant.Constants;
import com.cgr.dto.LoginBody;
import com.cgr.entity.CPUser;
import com.cgr.entity.LoginUser;
import com.cgr.service.WebService;
import com.cgr.utils.JwtUtil;
import com.cgr.utils.RedisUtil;
import com.cgr.utils.SecurityUtil;
import com.cgr.vo.LoginUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public ResponseModel login(LoginBody loginBody) {
        //封装到待认证对象
        UsernamePasswordAuthenticationToken unauthenticate =
                SecurityUtil.tokenUnauthenticate(loginBody.getUsername(), loginBody.getPassword());

        //这里会调用loadUserByUsername方法及密码加密
        Authentication authenticate = authenticationManager.authenticate(unauthenticate);
        //登录成功
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        // 生成token
        CPUser user = loginUser.getUser();
        String token = JwtUtil.generateToken(user);

        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtils.copyProperties(user, loginUserVo);
        loginUserVo.setToken(token);
        loginUserVo.setRoleList(loginUser.getRoleList());

        //存入Secuirty上下文
        SecurityUtil.setAuthentication(authenticate);

        //存入redis
        String key = Constants.LOGIN_USER_KEY + user.getId();
        redisUtil.setCacheObject(key, loginUser, Constants.USER_INFO_TTL, TimeUnit.MINUTES);

        return ResponseModel.success(loginUserVo);
    }
}
