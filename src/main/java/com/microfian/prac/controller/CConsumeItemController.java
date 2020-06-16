package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CConsumeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cousumeItem")
public class CConsumeItemController {

    @Autowired
    private CConsumeItemService cConsumeItemService;

    @PostMapping(value = "/listCousumeItem")
    public Object addAccount(@RequestBody CConsumeItemDTO cConsumeItemDTO){
        return cConsumeItemService.listCConsumeItem(cConsumeItemDTO);
    }
}
