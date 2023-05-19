package com.eve.service.impl;


import com.eve.entity.Food;
import com.eve.mapper.FoodMapper;
import com.eve.service.IFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanaijun
 * @since 2021-05-08
 */
@Service
@Slf4j
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {

//    @Resource
//    private RestHighLevelClient restHighLevelClient;

    private static final String food_index = "food";


    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Food> getFoods(){
        List<Food> list = new ArrayList<>();
        try {
//            SearchRequest searchRequest = new SearchRequest(food_index);
//            SearchSourceBuilder builder = new SearchSourceBuilder();
//            builder.query(QueryBuilders.matchAllQuery());
//            builder.from(0);
//            builder.size(1000);
//            searchRequest.source(builder);
//            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            SearchHit[] hits = response.getHits().getHits();
//            for(SearchHit hit : hits){
//                Food food= JSONObject.parseObject(hit.getSourceAsString(),Food.class);
//                list.add(food);
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean deleteByIdAnd(Integer id){
//        try {
//            getBaseMapper().deleteById(id);
//            DeleteRequest deleteRequest = new DeleteRequest(food_index,id.toString());
////            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
////            log.info(JSON.toJSONString(deleteResponse));
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return false;
    }

}
