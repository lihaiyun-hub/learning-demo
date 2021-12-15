package com.fusionskye.learning_deom.controller;

import com.fusionskye.learning_deom.dto.ResultBody;
import com.fusionskye.learning_deom.enums.CommonEnum;
import com.fusionskye.learning_deom.exception.BizException;
import com.fusionskye.learning_deom.po.User;
import com.fusionskye.learning_deom.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "获取用户信息")
@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation("添加用户信息")
    public ResultBody insert(@RequestBody User user) {
        System.out.println("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if (user.getUsername() == null) {
            // throw  new BizException("-1","用户姓名不能为空！");
            throw new BizException(CommonEnum.SIGNATURE_NOT_MATCH);
        }
        return ResultBody.success();
    }

    @PutMapping("/modifyUser")
    @ApiOperation("修改用户信息")
    public ResultBody update(@RequestBody User user) {
        System.out.println("开始更新...");

        return ResultBody.success();
    }

    @DeleteMapping("/removeUser")
    @ApiOperation("删除用户信息")
    public ResultBody delete(@RequestBody User user) {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return ResultBody.success();
    }

    @GetMapping("/selectUser")
    @ApiOperation("查询用户信息")
    public ResultBody findByUser() {
        System.out.println("开始查询...");
        List<User> userList = new ArrayList<>();
        userList = userService.selectAll();
        return ResultBody.success(userList);
    }

}