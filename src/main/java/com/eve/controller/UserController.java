package com.eve.controller;


import com.eve.base.ResponseResult;
import com.eve.entity.User;
import com.eve.service.IUserService;
import com.eve.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanaijun
 * @since 2021-04-27
 */
@RestController
@RequestMapping("/user")
@ResponseResult
public class UserController {

    @Autowired
    private IUserService iUserService;


    @RequestMapping("userInfo")
    public User userInfo(){
        return iUserService.getById(UserUtil.get().getId());
    }
}
