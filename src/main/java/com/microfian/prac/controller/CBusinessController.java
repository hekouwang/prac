package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CBussinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("bussiness")
public class CBusinessController {

    @Autowired
    private CBussinessService cBussinessService;

    @Autowired
    private CAccountService cAccountService;

    @PostMapping(value = "/addOneExpand")
    public Object addOneExpand(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        CAccountPO cAccountPO = checkAccount(cConsumeItemDTO);

        if(null ==cAccountPO){
            return null;
        }
        return cBussinessService.addOneExpand(cConsumeItemDTO,cAccountPO);

    }

    private CAccountPO checkAccount(CConsumeItemDTO cConsumeItemDTO){

        return cAccountService.selAccountById(cConsumeItemDTO.getSourceAccount());

    }

}
