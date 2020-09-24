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
@TableName("hot_details_list")
public class DetailsList extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 所属火锅店ID
     */
    private String storeId;

    /**
     * 所属消费者ID
     */
    private String orderId;

    /**
     * 菜品ID
     */
    private String foodId;

    /**
     * 消费数量
     */
    private Integer foodCount;

    /**
     * 菜品价格
     */
    private BigDecimal foodPrice;




}
