package com.eve;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.eve.entity.People;
import com.eve.service.IPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MycatApplicationTests {

    @Autowired
    private IPeopleService iPeopleService;




    @Test
    public void test2() {
//        List<String> messages = Arrays.asList("hello","baidu","redis");
//
//        messages.forEach(StringUtils::capitalize);
//        System.out.println(messages);
//        System.out.println(StringUtils.capitalize("hello"));
        List<People> list = iPeopleService.list();
        log.info("----list:{}", JSON.toJSONString(list));
    }

}
