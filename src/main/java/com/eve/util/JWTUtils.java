package com.eve.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.eve.entity.User;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author hanneys
 * @Date 2021/4/27 15:46
 * @Version 1.0
 */
public class JWTUtils {

    /**
     签发对象：这个用户的id
     签发时间：现在
     有效时间：30分钟
     载荷内容：暂时设计为：这个人的名字，这个人的昵称
     加密密钥：这个人的id加上一串字符串
     */
    public static String createToken(User u) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(u.getId().toString())   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userId", u.getId())
                .withClaim("phone", u.getPhone())    //载荷，随便写几个都可以
                .sign(Algorithm.HMAC256(u.getId()+"HelloLehr"));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     * @param token
     * @throws
     */
    public static void verifyToken(String token, String secret) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret+"HelloLehr")).build();
        verifier.verify(token);

    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        return JWT.decode(token).getAudience().get(0);
    }


    /**
     * 通过载荷名字获取载荷的值
     */
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}
