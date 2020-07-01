package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.DTO.ClassifyAndConsumeReturnDTO;
import com.microfian.prac.DTO.ResCConsumeItem;
import com.microfian.prac.service.CConsumeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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

        List<ResCConsumeItem> list = cConsumeItemService.listCConsumeItem(cConsumeItemDTO);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("items", list);
        map1.put("total", 0);
        if(!CollectionUtils.isEmpty(list)){
            map1.put("total", list.size());
            map1.put("totalCount",list.get(0).getTotalCount());
        }
        map.put("data", map1);
        map.put("code", 20000);
        return map;

    }

    @PostMapping(value = "/listConsumeItemGroupAndOrder")
    public Object listConsumeItemGroupAndOrder(@RequestBody CConsumeItemDTO cConsumeItemDTO) {

        List<ClassifyAndConsumeReturnDTO> classifyAndConsumeReturnDTOS =
                cConsumeItemService.listConsumeItemGroupAndOrder(cConsumeItemDTO);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("items", classifyAndConsumeReturnDTOS);
        map1.put("total", 0);
        if(!CollectionUtils.isEmpty(classifyAndConsumeReturnDTOS)){
            map1.put("total", classifyAndConsumeReturnDTOS.size());
        }
        map.put("data", map1);
        map.put("code", 20000);
        return map;

    }
}
