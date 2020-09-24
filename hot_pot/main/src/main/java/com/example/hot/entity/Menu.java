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
@TableName("hot_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 所属火锅店ID
     */
    private String storeId;

    /**
     * 名称
     */
    private String foodName;

    /**
     * 类型
     */
    private String foodType;

    /**
     * 价格
     */
    private BigDecimal foodPrice;

    /**
     * 库存
     */
    private Integer foodTotal;

    /**
     * 销量
     */
    private Integer foodCount;

    /**
     * 菜品图片
     */
    private String foodPic;



}
