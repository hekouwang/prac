package com.microFian.prac.web.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResClassifyChildrenVo {

    private String label;

    private Integer value;

    private Integer id;

    private Integer parentId;

    private String name;

}
