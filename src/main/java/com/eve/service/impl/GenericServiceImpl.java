package com.eve.service.impl;

import com.eve.entity.Generic;
import com.eve.service.GenericService;
import org.springframework.stereotype.Service;

/**
 * @Author hanneys
 * @Date 2021/1/19 10:21
 * @Version 1.0
 */
@Service
public class GenericServiceImpl implements GenericService {

    public void test() {
        Generic<Integer> integerGeneric = new Generic<>();
        integerGeneric.setKey(123);


    }
}
