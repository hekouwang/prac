package com.microfian.prac.response;

import com.microfian.prac.DTO.ClassifyChildrenVo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ResClassifyVo {

    private String label;

    private Integer value;

    private Integer id;

    private Integer parentId;

    private String name;

    private List<ClassifyChildrenVo> children;
}
