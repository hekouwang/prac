package com.microFian.prac.web.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class CClassifyDTO {

    private Integer id;

    private String classifyName;

    private Integer parentId;

    private String createTime;

    private Date updateTime;

    private Integer isAvailable;

    private Integer isDeleted;

    private Integer order;

    /**
     * 分类类型（1 出 2 入）
     */
    private String classifyType;

}