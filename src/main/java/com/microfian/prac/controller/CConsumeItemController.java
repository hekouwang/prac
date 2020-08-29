package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.DTO.ClassifyAndConsumeReturnDTO;
import com.microfian.prac.DTO.ResCConsumeItem;
import com.microfian.prac.request.ReqClassify;
import com.microfian.prac.response.ResAccount;
import com.microfian.prac.response.ResBrokenLine;
import com.microfian.prac.response.ResMoneyAndClassify;
import com.microfian.prac.response.Result;
import com.microfian.prac.service.CConsumeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cousumeItem")
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
    public Object listConsumeItemGroupAndOrder(@RequestBody ReqClassify reqClassify) {

        List<ClassifyAndConsumeReturnDTO> classifyAndConsumeReturnDTOS =
                cConsumeItemService.listConsumeItemGroupAndOrder(reqClassify);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<String> classifyList=new ArrayList<>();
        List<BigDecimal> moneyList=new ArrayList<>();
        if(!CollectionUtils.isEmpty(classifyAndConsumeReturnDTOS)){
            map1.put("total", classifyAndConsumeReturnDTOS.size());
            for(ClassifyAndConsumeReturnDTO classifyAndConsumeReturnDTO:classifyAndConsumeReturnDTOS){
                classifyList.add(classifyAndConsumeReturnDTO.getClassifyName());
                moneyList.add(classifyAndConsumeReturnDTO.getMoney());
            }
            map1.put("classifyList",classifyList);
            map1.put("moneyList",moneyList);
        }
        map.put("data", map1);
        map.put("code", 20000);
        return map;

    }

    @PostMapping(value = "/listConsumeItemGroupAndOrderCake")
    public Object listConsumeItemGroupAndOrderCake(@RequestBody ReqClassify reqClassify) {

        List<ClassifyAndConsumeReturnDTO> classifyAndConsumeReturnDTOS =
                cConsumeItemService.listConsumeItemGroupAndOrder(reqClassify);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<String> classifyList=new ArrayList<>();
        List<ResMoneyAndClassify> moneyList=new ArrayList<>();
        if(!CollectionUtils.isEmpty(classifyAndConsumeReturnDTOS)){
            map1.put("total", classifyAndConsumeReturnDTOS.size());
            for(ClassifyAndConsumeReturnDTO classifyAndConsumeReturnDTO:classifyAndConsumeReturnDTOS){
                classifyList.add(classifyAndConsumeReturnDTO.getClassifyName());
                ResMoneyAndClassify resMoneyAndClassify=new ResMoneyAndClassify();
                resMoneyAndClassify.setValue(classifyAndConsumeReturnDTO.getMoney());
                resMoneyAndClassify.setName(classifyAndConsumeReturnDTO.getClassifyName());
                moneyList.add(resMoneyAndClassify);
            }
            map1.put("classifyList",classifyList);
            map1.put("moneyList",moneyList);
        }
        map.put("data", map1);
        map.put("code", 20000);
        return map;

    }


    @PostMapping(value = "/listConsumeItemBrokenLine")
    public Object listConsumeItemBrokenLine(@RequestBody CConsumeItemDTO cConsumeItemDTO) {

        Result<ResBrokenLine> result=new Result<>();
        ResBrokenLine resBrokenLine=new ResBrokenLine();
        result.setCode(20000);
        result.setMsg("成功");
        List<ResCConsumeItem> list = cConsumeItemService.listCConsumeItemBrokenLine(cConsumeItemDTO);
        if(org.apache.commons.collections.CollectionUtils.isEmpty(list)){
            return result;
        }
        List<String>  classifyList=new ArrayList<>();
        List<BigDecimal> inList=new ArrayList<>();
        List<BigDecimal> outList=new ArrayList<>();;
        List<BigDecimal> balanceList=new ArrayList<>();;
        for(ResCConsumeItem resCConsumeItem:list){
            classifyList.add(resCConsumeItem.getDate());
            inList.add(resCConsumeItem.getIn());
            outList.add(resCConsumeItem.getOut());
            balanceList.add(resCConsumeItem.getBalance());
        }
        resBrokenLine.setClassifyList(classifyList);
        resBrokenLine.setInList(inList);
        resBrokenLine.setOutList(outList);
        resBrokenLine.setBalanceList(balanceList);
        result.setData(resBrokenLine);
        return result;

    }
}
