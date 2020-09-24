package com.example.hot.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.hot.base.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author administrator
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("hot_order_list")
public class OrderList extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 所属火锅店ID
     */
    private String storeId;

    /**
     * 所属消费者ID
     */
    private String customerId;

    /**
     * 订单消费金额
     */
    private BigDecimal orderPrice;

    /**
     * 菜品选购数量
     */
    private Integer foodCount;




}
