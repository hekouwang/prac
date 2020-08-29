package com.microfian.prac.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ResCConsumeItem {

    private String date;

    private BigDecimal in;

    private BigDecimal out;


    private BigDecimal balance;

    private TotalCount totalCount;



    private List<CConsumeItemReturnDTO> cConsumeItemReturnDTOList;
}
