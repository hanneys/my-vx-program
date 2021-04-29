package com.eve.service;

import com.eve.entity.People;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hanaijun
 * @since 2020-12-09
 */
public interface IPeopleService extends IService<People> {

    List<People> inSql();
}
