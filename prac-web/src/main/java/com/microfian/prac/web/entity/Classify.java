package com.microFian.prac.web.entity;

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
 * <p>
 *
 * </p>
 *
 * @author tony
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_classify")
public class Classify extends Model<Classify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 父类
     */
    private Integer parentId;

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
     * 排序
     */
    private Integer classifyOrder;

    /**
     * 分类类型（1 出 2 入）
     */
    private String classifyType;

    /**
     * 账本id
     */
    private Integer accountBookId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}