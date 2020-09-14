package com.microFian.prac.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_consume_item")
public class ConsumeItem extends Model<ConsumeItem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 类型（1 支出  2 收入  3转账  4  退款）
     */
    private Integer consumeType;

    /**
     * 分类
     */
    private String classifyId;

    /**
     * 源账户
     */
    private String sourceAccount;

    /**
     * 目标账户
     */
    private String targetAccount;

    /**
     * 商家id
     */
    private String merchantId;

    /**
     * 项目id
     */
    private String projectId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否可用
     */
    private Integer isAvailable;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 用户
     */
    private String userId;

    /**
     * 用户关系
     */
    private String relationId;

    /**
     * 账本id
     */
    private Integer accountBookId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
