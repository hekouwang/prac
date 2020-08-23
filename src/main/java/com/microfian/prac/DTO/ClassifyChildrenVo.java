package com.microfian.prac.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClassifyChildrenVo {

    private String label;

    private Integer value;

    private Integer id;

    private Integer parentId;

    private String name;

}
