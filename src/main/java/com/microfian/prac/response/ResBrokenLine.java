package com.microfian.prac.response;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
public class ResBrokenLine {

    private List<String>  classifyList;

    private List<BigDecimal> inList;

    private List<BigDecimal> outList;

    private List<BigDecimal> balanceList;

}
