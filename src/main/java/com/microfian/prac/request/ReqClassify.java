package com.microfian.prac.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class ReqClassify {

    private Integer id;

    private String classifyName;

    private Integer parentId;

    private String createTime;

    private Date updateTime;

    private Integer isAvailable;

    /**
     * 分类类型（1 出 2 入）
     */
    private Integer classifyType;


    private Integer isDeleted;

    private Integer order;

    private Integer classifyLevel;

    private List<String> startAndEndTime;

    private String startTime;

    private String endTime;


}