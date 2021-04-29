package com.eve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eve.entity.People;
import com.eve.mapper.PeopleMapper;
import com.eve.service.IPeopleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanaijun
 * @since 2020-12-09
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements IPeopleService {



    /**
     * 在同一个方法中切换数据源，该方法上有事务注解（@Transactional）时，
     * 动态数据源切换失效，不管DS还是DynamicDataSourceContextHolder都失效，
     * 所以尽量拆到service中不同的方法中（支持@Transactional）来处理，最终由controller调用实现业务逻辑
     *
     * @return
     */
    @Override
//    @DS("slave_1")
//    @Transactional(rollbackFor = Exception.class)
    public List<People> list() {

//        DynamicDataSourceContextHolder.push("slave_2");
        //        kafkaTemplate.send("topic.test", list);
        return getBaseMapper().selectList(new QueryWrapper<>());
    }


    /**
     * allEq
     * allEq({id:1,name:"老王",age:null})--->id = 1 and name = '老王' and age is null
     * allEq({id:1,name:"老王",age:null}, false)--->id = 1 and name = '老王'
     * 加入false条件则会忽略为空的字段
     *
     * @param id
     * @param name
     * @return
     */
    public List<People> allEq(String id, String name) {
        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("name", name);
        param.put("age", null);
        queryWrapper.allEq(param, false);
        return list(queryWrapper);
    }


    /**
     * inSql("id", "select id from table where id < 3")--->id in (select id from table where id < 3)
     * <p>
     * notInSql("id", "select id from table where id < 3")--->id not in (select id from table where id < 3)
     *
     * @return
     */
    @Override
    public List<People> inSql() {
//        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
//        queryWrapper.inSql("id","");
        LambdaQueryWrapper<People> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(People::getId, "select id from test where id >" + 2);
        return list(lambdaQueryWrapper);
    }

    public void zzz() {
        QueryWrapper<People> queryWrapper = new QueryWrapper<>();

    }


    private static final ThreadLocal<String> SCHEMA_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
//        WeekFields weekFields = WeekFields.of(Locale.getDefault());
//        int weekNumber = LocalDate.now().get(weekFields.weekOfWeekBasedYear());
//        int i = weekNumber % 3;
//        Map<String, Object> map5 = new HashMap<>();
//        map5.put("成品菜","a");
//        map5.put("底料库","m");
//        map5.put("保鲜库","s");

        double[] x = {1, 2, 3, 4, 5, 6};
        System.out.println(variance(x));
        System.out.println(pop_variance(x));

    }


    public static double variance(double[] x) {
        int m = x.length;
        double sum = 0;
        for (double v : x) {//求和
            sum += v;
        }
        double dAve = sum / m;//求平均值
        double dVar = 0;
        for (double v : x) {//求方差
            dVar += (v - dAve) * (v - dAve);
        }
        return dVar / m;
    }

    static double pop_variance(double[] data) {
        double variance = 0;
        for (double datum : data) {
            variance = variance + (Math.pow((datum - mean(data)), 2));
        }
        variance = variance / data.length;
        return variance;
    }

    static double mean(double[] data) {
        double mean = 0;
        mean = sum(data) / data.length;
        return mean;
    }

    static double sum(double[] data) {
        double sum = 0;
        for (double datum : data) {
            sum = sum + datum;
        }
        return sum;
    }


}
