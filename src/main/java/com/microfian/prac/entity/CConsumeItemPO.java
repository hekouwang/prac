package com.microfian.prac.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CConsumeItemPO {
    private String id;

    private BigDecimal money;

    private Integer consumeType;

    private String classifyId;

    private String sourceAccount;

    private String targetAccount;

    private String merchantId;

    private String projectId;

    private String remark;

    private String createTime;

    private String updateTime;

    private Integer isAvailable;

    private Integer isDeleted;

    private String userId;

    private String relationId;

    private String accountBookId;

}