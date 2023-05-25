package com.eve.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class TExData extends Model<TExData> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String companyId;

    private String companyName;

    private LocalDateTime createTime;

    private BigDecimal amount;


}
