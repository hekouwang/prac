package com.microfian.prac.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ClassifyVo {

    private String label;

    private Integer value;

    private List<ClassifyChildrenVo> children;
}
