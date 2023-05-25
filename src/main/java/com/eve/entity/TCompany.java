package com.eve.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanaijun
 * @since 2023-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 租户编码
     */
    private String tenantCode;

    private String companyId;

    private String corpId;

    private String name;

    private String shortName;

    private String companyType;

    private String certCode;

    private String province;

    private String provinceName;

    private String city;

    private String cityName;

    private String distrct;

    private String distrctName;

    private String address;

    private String longitude;

    private String latitude;

    private String nature;

    private String businessCity;

    private String businessCityExtend;

    private String hasWarehourseBiz;

    private String pricePeriod;

    private String isSelfDelivery;

    private String isInvoice;

    private String accountPeriod;

    private String accountPeriodMonthsDay;

    private String creditLimit;

    private String isDisplayPrice;

    private String arrivalPeriod;

    private String arrivalBeginTime;

    private String arrivalEndTime;

    private String orderEndTime;

    private String replenishEndTime;

    private String isPrintDeliveryOrder;

    private String isPrintJoinPrice;

    private String isPrintSalesPrice;

    private String paymentWay;

    private String settlementWay;

    private String isFreeShip;

    private String fenceSwitch;

    private String fenceRadius;

    private String status;

    private String creator;

    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    private String lastModifier;

    private String lastModifyTime;

    private String isDeleted;

    private String customerCategory;

    private String pushWmsStatus;

    private String sapCustomerId;

    private String paymentDay;

    private String affiliatedEnterprise;

    private String warehoursePricingModel;

    private String mergeOrderConfig;

    private String mergeOrderTime;

    private String signForConfig;


}
