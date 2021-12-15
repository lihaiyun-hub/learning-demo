package com.fusionskye.learning_deom.po;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LHY
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @ApiModelProperty(value = "id")
    private int id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "是否有管理员权限")
    private int adminFlag;


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}