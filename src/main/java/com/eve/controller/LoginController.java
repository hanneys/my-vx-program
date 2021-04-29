package com.eve.controller;

import com.eve.aspect.SysLog;
import com.eve.base.BizException;
import com.eve.base.ResponseResult;
import com.eve.constant.RedisConstants;
import com.eve.entity.User;
import com.eve.util.JWTUtils;
import com.eve.service.IUserService;
import com.eve.util.LibphonenumberUtil;
import com.eve.util.RedisUtil;
import com.eve.util.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hanneys
 * @Date 2021/4/27 15:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
@Slf4j
@ResponseResult
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IUserService iUserService;


    /**
     * 发送验证码
     * @param phone
     */
    @RequestMapping("sendMsgCode")
    @SysLog
    public void sendMsgCode(@RequestParam("phone")String phone){
        if(StringUtils.isEmpty(phone)|| !LibphonenumberUtil.doValidUniversal(phone)){
            throw new BizException("请输入有效的手机号");
        }
        String code=VerifyCodeUtil.getCode();
        log.info("验证码:{}",VerifyCodeUtil.getCode());
        redisUtil.set(RedisConstants.PHONE_CODE + phone, code,5*60);
    }


    /**
     * 验证码登录
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping("login")
    public Map<String,Object> login(@RequestParam("phone") String phone, @RequestParam("code") String code){
        if(StringUtils.isEmpty(phone)|| !LibphonenumberUtil.doValidUniversal(phone)){
            throw new BizException("请输入有效的手机号");
        }
        if(StringUtils.isEmpty(code)){
            throw new BizException("请输入验证码");
        }
        Object redisCode = redisUtil.get(RedisConstants.PHONE_CODE + phone);
        if(StringUtils.isEmpty(redisCode)){
            throw new BizException("验证码已失效");
        }
        if(!code.equals(redisCode.toString())){
            throw new BizException("验证码错误");
        }
        User user = iUserService.getUserByPhone(phone);
        if(StringUtils.isEmpty(user)){
            user = new User();
            user.setPhone(phone);
            iUserService.save(user);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("token",JWTUtils.createToken(user));
        return map;
    }


}
