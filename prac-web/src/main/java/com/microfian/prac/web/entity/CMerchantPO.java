package com.microfian.prac.web.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CMerchantPO {
    private String id;

    private String merchantName;

    private String createTime;

    private Date updateTime;

    private Integer isAvailable;

    private Integer isDeleted;

    private String userId;

}