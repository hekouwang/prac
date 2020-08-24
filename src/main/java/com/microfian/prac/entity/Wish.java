package com.microfian.prac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author hekouwang
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_wish")
public class Wish extends Model<Wish> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 心愿名称
     */
    private String name;

    private Integer accountId;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;


    /**
     * 每日金额
     */
    private BigDecimal dayMoney;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否可用
     */
    private Integer isAvailable;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账本id
     *
     */
    private Integer accountBookId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
