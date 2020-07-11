package com.microfian.prac.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class TotalCount {

    private BigDecimal totalIncome;

    private BigDecimal totalExpense;

    private BigDecimal toalRemain;

    private String startTime;

    private String endTime;
}
