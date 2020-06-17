package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.service.CConsumeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cousumeItem")
public class CConsumeItemController {

    @Autowired
    private CConsumeItemService cConsumeItemService;

    @PostMapping(value = "/listCousumeItem")
    public Object addAccount(@RequestBody CConsumeItemDTO cConsumeItemDTO) {
        List<CConsumeItemReturnDTO> list = cConsumeItemService.listCConsumeItem(cConsumeItemDTO);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("items", list);
        map1.put("total", 12);
        map.put("data", map1);
        map.put("code", 20000);
        return map;
    }
}
