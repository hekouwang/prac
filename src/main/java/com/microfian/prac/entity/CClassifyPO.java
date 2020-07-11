package com.microfian.prac.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class CClassifyPO {
    private Integer id;

    private String classifyName;

    private String parentId;

    private String createTime;

    private Date updateTime;

    private Integer isAvailable;

    private Integer isDeleted;

    private Integer order;

}