package com.cgr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {

    private Long id;

    private String username;

    private String nickName;

    private String avatar;

    private String email;

    private String phone;

    private String sex;

    /**
     * 角色列表
     */
    private Set<String> roleList;

    private String token;
}
