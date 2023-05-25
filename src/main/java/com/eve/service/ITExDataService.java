package com.eve.service;

import com.eve.entity.TExData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanaijun
 * @since 2023-05-25
 */
public interface ITExDataService extends IService<TExData> {

    void saveData();
}
