package com.eve.service;

import com.eve.entity.People;

import java.util.List;

/**
 * @Author hanneys
 * @Date 2021/4/15 14:03
 * @Version 1.0
 */
public interface PeopleProcessService {


    void insert(List<People> list);

    void update(List<People> list);

    void delete(List<People> list);
}
