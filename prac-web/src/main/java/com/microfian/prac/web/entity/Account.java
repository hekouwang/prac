package com.microFian.prac.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hekouwang
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_account")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账户名
     */
    private String accountName;

    /**
     * 父账户id
     */
    private Integer parentAccountId;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 账户类型（1 普通账户  2 负债账户）
     */
    private Integer accountType;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否可用
     */
    private Integer isAvailable;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 用户id
     */
    private String userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
