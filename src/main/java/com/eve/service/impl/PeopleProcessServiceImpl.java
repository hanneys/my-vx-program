package com.eve.service.impl;

import com.alibaba.fastjson.JSON;
import com.eve.entity.People;
import com.eve.service.IPeopleService;
import com.eve.service.PeopleProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author hanneys
 * @Date 2021/4/15 14:11
 * @Version 1.0
 */
@Service
@Slf4j
public class PeopleProcessServiceImpl implements PeopleProcessService {

    @Autowired
    private IPeopleService iPeopleService;

    @Override
    public void insert(List<People> list) {
        log.info("PeopleProcess-add-list:{}", JSON.toJSONString(list));
        iPeopleService.saveBatch(list);
    }

    @Override
    public void update(List<People> list) {
        log.info("PeopleProcess-update-list:{}", JSON.toJSONString(list));
        iPeopleService.updateBatchById(list);
        List<People> listz = iPeopleService.list();
        log.info("----list:{}", JSON.toJSONString(listz));
    }


    @Override
    public void delete(List<People> list) {
        log.info("PeopleProcess-delete-list:{}", JSON.toJSONString(list));
        iPeopleService.removeByIds(list.stream().map(People::getId).collect(Collectors.toList()));
    }


    public static void main(String[] args) {
        String ss = "ss";
        List<People> list = new ArrayList<>();


    }
}
