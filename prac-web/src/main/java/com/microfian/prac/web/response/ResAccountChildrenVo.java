package com.microfian.prac.web.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ResAccountChildrenVo {

    private String label;

    private Integer value;

    private Integer id;

    private Integer parentId;

    private String name;

    private BigDecimal totalBalance;

    private BigDecimal balance;

}
