package com.eve.controller;


import com.eve.aspect.SysLog;
import com.eve.base.BizException;
import com.eve.base.ResponseResult;
import com.eve.entity.People;
import com.eve.service.IPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanaijun
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/people")
@Slf4j
@ResponseResult

public class PeopleController {

    @Autowired
    private IPeopleService iPeopleService;


    @PostMapping("add")
    public void zzz() {
        List<People> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            People people = new People();
            list.add(people);
        }

        iPeopleService.saveBatch(list);
    }

    @SysLog
    @PostMapping("select")
    public List<People> select() {
        return iPeopleService.list();
    }

    @PostMapping("inSql")
    public List<People> inSql() {
        return iPeopleService.inSql();
    }


}
