package com.microfian.prac.web.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
public class ResAccountVo {

    private String label;

    private Integer value;

    private Integer id;

    private BigDecimal totalBalance;

    private BigDecimal balance;

    private Integer parentId;

    private String name;

    private List<ResAccountChildrenVo> children;
}
