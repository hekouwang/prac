package com.joyuai.vacation.product.dao.generator.entity;

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
 * @author hekouwang
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("c_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String rolename;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
