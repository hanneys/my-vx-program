package com.eve.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author hanneys
 * @Date 2020/12/30 10:49
 * @Version 1.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject); // 起始版本 3.3.0(推荐使用)
        setInsertFieldValByName("updateTime", LocalDateTime.now(), metaObject); // 起始版本 3.3.0(推荐使用)

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject); // 起始版本 3.3.0(推荐)

    }
}
