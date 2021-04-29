package com.eve.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author hanneys
 * @Date 2021/2/7 14:05
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class ShopInfo {


    /**
     * shopCode : 1120
     * shopName : 北京二十店
     * material : [{"id":"1120-3705846 ","materialCode":"3705846","materialName":"宽苕粉（120G/盒）","materialSpecification":"","dishCode":"41280","dishName":"宽苕粉","unitCode":"","unitName":"盒","houseCode":"1120","houseName":"默认仓库","locationCode":"1120","locationName":"默认库位","amount":148,"overdueAmount":3,"nearOverdueAmount":0,"normalAmount":145,"createTime":"2020-04-11 07:30:00","updateTime":"2020-11-12 14:30:00"},{"id":"1120-3707633","materialCode":"3707633","materialName":"小郡肝（125G/盒）","materialSpecification":"","dishCode":"33510","dishName":"小郡肝","unitCode":"","unitName":"盒","houseCode":"1120","houseName":"默认仓库","locationCode":"1120","locationName":"默认库位","amount":55,"overdueAmount":1,"nearOverdueAmount":0,"normalAmount":54,"createTime":"2020-10-20 12:30:00","updateTime":"2020-11-12 14:30:00"}]
     */

    private String shopCode;
    private String shopName;
    private List<Material> material;

    @NoArgsConstructor
    @Data
    public static class Material {
        /**
         * id : 1120-3705846
         * materialCode : 3705846
         * materialName : 宽苕粉（120G/盒）
         * materialSpecification :
         * dishCode : 41280
         * dishName : 宽苕粉
         * unitCode :
         * unitName : 盒
         * houseCode : 1120
         * houseName : 默认仓库
         * locationCode : 1120
         * locationName : 默认库位
         * amount : 148
         * overdueAmount : 3
         * nearOverdueAmount : 0
         * normalAmount : 145
         * createTime : 2020-04-11 07:30:00
         * updateTime : 2020-11-12 14:30:00
         */

        private String id;
        private String materialCode;
        private String materialName;
        private String materialSpecification;
        private String dishCode;
        private String dishName;
        private String unitCode;
        private String unitName;
        private String houseCode;
        private String houseName;
        private String locationCode;
        private String locationName;
        private int amount;
        private int overdueAmount;
        private int nearOverdueAmount;
        private int normalAmount;
        private String createTime;
        private String updateTime;
    }
}
