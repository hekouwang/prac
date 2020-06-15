package com.microfian.prac.entity;

import java.math.BigDecimal;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount == null ? null : sourceAccount.trim();
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount == null ? null : targetAccount.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    public String getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(String accountBookId) {
        this.accountBookId = accountBookId == null ? null : accountBookId.trim();
    }
}