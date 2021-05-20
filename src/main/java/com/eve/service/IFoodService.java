package com.eve.service;

import com.eve.entity.Food;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanaijun
 * @since 2021-05-08
 */
public interface IFoodService extends IService<Food> {

    List<Food> getFoods();

    boolean deleteByIdAnd(Integer id);
}
