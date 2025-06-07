package com.cgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("cp_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CPMenu implements Serializable {

    private Long id;

    private String menuName;
}
