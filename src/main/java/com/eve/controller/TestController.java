package com.eve.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hanneys
 * @Date 2021/1/19 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {


    @RequestMapping("zz")
    public String test1() {
        return "kill";
    }


}
