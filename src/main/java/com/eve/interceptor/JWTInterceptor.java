package com.eve.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.eve.base.BizException;
import com.eve.entity.User;
import com.eve.service.IUserService;
import com.eve.util.JWTUtils;
import com.eve.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author hanneys
 * @Date 2021/4/27 15:49
 * @Version 1.0
 */
@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService iUserService;

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try {
            String userId = JWTUtils.getAudience(token);
            User u = iUserService.getById(userId);
            if(StringUtils.isEmpty(u)){
                throw new BizException("用户不存在，请重新登录");
            }
            JWTUtils.verifyToken(token,userId);
            UserUtil.set(u);
        }catch (SignatureVerificationException e){
            throw new BizException("无效签名");
        }catch (TokenExpiredException e){
            throw new BizException("token算法不一致");
        }catch (AlgorithmMismatchException e){
            throw new BizException("token过期");
        }catch (Exception e){
            e.printStackTrace();
            throw new BizException("token无效");
        }
        return true;
    }
}
