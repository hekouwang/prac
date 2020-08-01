package com.microfian.prac.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ResMoneyAndClassify {

    private BigDecimal value;

    private String name;
}
