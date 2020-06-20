package com.microfian.prac.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CConsumeItemReturnDTO {

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

    private String classifyName;

    private String merchantName;

    private String projectName;

    private String sourceAccountName;

    private String targetAccountName;

    public String  getDay(){
        return this.createTime.substring(0,10);
    }

}