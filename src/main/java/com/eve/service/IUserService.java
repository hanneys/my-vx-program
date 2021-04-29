package com.eve.service;

import com.eve.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanaijun
 * @since 2021-04-27
 */
public interface IUserService extends IService<User> {

    User getUserByPhone(String phone);
}
