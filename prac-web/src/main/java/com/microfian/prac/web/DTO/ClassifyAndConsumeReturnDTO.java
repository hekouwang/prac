package com.microfian.prac.web.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ClassifyAndConsumeReturnDTO {

    private String classifyName;

    private BigDecimal money;
}