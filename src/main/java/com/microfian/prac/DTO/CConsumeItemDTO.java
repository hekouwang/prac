package com.microfian.prac.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CConsumeItemDTO {

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

    private List<Integer> classifyList;

    private List<Integer> accountList;

    private List<Integer> merchantList;

    private List<Integer> projectList;

    private List<Integer> relationList;

    private List<String> timeList;

    private String startTime;

    private String endTime;




}