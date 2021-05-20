package com.eve.controller;


import com.eve.base.ResponseResult;
import com.eve.entity.Food;
import com.eve.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanaijun
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/food")
@ResponseResult
public class FoodController {

    @Autowired
    private IFoodService iFoodService;

    @PostMapping("test")
    public List<Food> test(){
        return iFoodService.getFoods();
    }

    @PostMapping("deleteByIdAnd")
    public void deleteByIdAnd(@RequestParam(value = "id") Integer id){
         iFoodService.deleteByIdAnd(id);
    }

}
