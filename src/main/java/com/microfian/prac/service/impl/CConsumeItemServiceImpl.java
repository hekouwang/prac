package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.*;
import com.microfian.prac.entity.CClassifyPO;
import com.microfian.prac.entity.CConsumeItemPO;
import com.microfian.prac.mapper.CClassifyPOMapper;
import com.microfian.prac.mapper.CConsumeItemPOMapper;
import com.microfian.prac.service.CConsumeItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CConsumeItemServiceImpl implements CConsumeItemService {

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;

    @Autowired
    private CClassifyPOMapper cClassifyPOMapper;

    @Override
    public List<ResCConsumeItem> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO) {

        //判断是否传了类别
        if(!CollectionUtils.isEmpty(cConsumeItemDTO.getClassifyList())){
            List<Integer> list=new ArrayList<>();
            for(List<Integer> list1:cConsumeItemDTO.getClassifyList()){
                list.addAll(list1);
            }
            cConsumeItemDTO.setRealClassifyList(list);
        }

        //判断是否传了时间,没有的话取当前日期所在月份第一天和最后一天
        if(!CollectionUtils.isEmpty(cConsumeItemDTO.getStartAndEndTime())){
            String startTime=cConsumeItemDTO.getStartAndEndTime().get(0)+" 00:00:00";
            String endTime=cConsumeItemDTO.getStartAndEndTime().get(1)+" 23:59:59";
            cConsumeItemDTO.setStartTime(startTime);
            cConsumeItemDTO.setEndTime(endTime);
        }
        else{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            //获取当前月第一天：
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            String monthfirst = format.format(c.getTime());

            //获取当前月最后一天
            Calendar ca = Calendar.getInstance();
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            String monthlast = format.format(ca.getTime());
            String startTime=monthfirst+" 00:00:00";
            String endTime=monthlast+" 23:59:59";
            cConsumeItemDTO.setStartTime(startTime);
            cConsumeItemDTO.setEndTime(endTime);
        }
        List<CConsumeItemReturnDTO> list = cConsumeItemPOMapper.selByCondition(cConsumeItemDTO);
        List<ResCConsumeItem> resCConsumeItemList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return resCConsumeItemList;
        }

        //当前时间段的总支出，总收入
        TotalCount totalCount = new TotalCount();
        BigDecimal totalIncome = new BigDecimal("0");
        BigDecimal totalExpense = new BigDecimal("0");
        BigDecimal toalRemain = new BigDecimal("0");
        String startTime = "";
        String endTime = "";
        for (CConsumeItemReturnDTO cConsumeItemReturnDTO : list) {
            if (1 == cConsumeItemReturnDTO.getConsumeType()) {
                totalExpense = totalExpense.add(cConsumeItemReturnDTO.getMoney());
            } else if (2 == cConsumeItemReturnDTO.getConsumeType()) {
                totalIncome = totalIncome.add(cConsumeItemReturnDTO.getMoney());
            }
        }
        startTime = list.get(0).getCreateTime();
        endTime = list.get(list.size() - 1).getCreateTime();
        totalCount.setTotalIncome(totalIncome);
        totalCount.setTotalExpense(totalExpense);
        totalCount.setToalRemain(totalIncome.subtract(totalExpense));
        totalCount.setStartTime(startTime);
        totalCount.setEndTime(endTime);

        Map<String, List<CConsumeItemReturnDTO>> map = list.stream().collect(
                Collectors.groupingBy(CConsumeItemReturnDTO::getDay, LinkedHashMap::new, Collectors.toList()));

        for (Map.Entry<String, List<CConsumeItemReturnDTO>> entry : map.entrySet()) {
            ResCConsumeItem resCConsumeItem = new ResCConsumeItem();
            resCConsumeItem.setDate(entry.getKey());
            resCConsumeItem.setTotalCount(totalCount);
            BigDecimal in = new BigDecimal("0");
            BigDecimal out = new BigDecimal("0");
            List<CConsumeItemReturnDTO> entryList = entry.getValue();
            for (CConsumeItemReturnDTO cConsumeItemReturnDTO : entryList) {
                if (cConsumeItemReturnDTO.getConsumeType() == 1) {
                    out = out.add(cConsumeItemReturnDTO.getMoney());
                } else if (cConsumeItemReturnDTO.getConsumeType() == 2) {
                    in = in.add(cConsumeItemReturnDTO.getMoney());
                }
            }
            //按提交时间降序--stream写法
            entryList = entryList.stream().sorted(Comparator.comparing(CConsumeItemReturnDTO::getCreateTime).
                    reversed()).collect(Collectors.toList());//根据创建时间倒排

            resCConsumeItem.setIn(in);
            resCConsumeItem.setOut(out);
            resCConsumeItem.setCConsumeItemReturnDTOList(entryList);
            resCConsumeItemList.add(resCConsumeItem);
        }
        return resCConsumeItemList;
    }

    @Override
    public List<ClassifyAndConsumeReturnDTO> listConsumeItemGroupAndOrder(CConsumeItemDTO cConsumeItemDTO) {

        List<ClassifyAndConsumeReturnDTO> list=new ArrayList<>();
        CClassifyDTO cClassifyDTO=new CClassifyDTO();
        cClassifyDTO.setParentId(0);
        List<CClassifyPO> cClassifyPOS = cClassifyPOMapper.selCClassify(cClassifyDTO);
        //判断是否传了时间,没有的话取当前日期所在月份第一天和最后一天
        if(!CollectionUtils.isEmpty(cConsumeItemDTO.getStartAndEndTime())){
            String startTime=cConsumeItemDTO.getStartAndEndTime().get(0)+" 00:00:00";
            String endTime=cConsumeItemDTO.getStartAndEndTime().get(1)+" 23:59:59";
            cConsumeItemDTO.setStartTime(startTime);
            cConsumeItemDTO.setEndTime(endTime);
        }
        if(CollectionUtils.isEmpty(cClassifyPOS)){
            return null;
        }
        for(CClassifyPO cClassifyPO:cClassifyPOS){
            ClassifyAndConsumeReturnDTO classifyAndConsumeReturnDTO=new ClassifyAndConsumeReturnDTO();
            classifyAndConsumeReturnDTO.setClassifyName(cClassifyPO.getClassifyName());
            List<CConsumeItemPO> cConsumeItemReturnDTOS = cConsumeItemPOMapper.selByParentId(cClassifyPO.getId());
            BigDecimal out = new BigDecimal("0");
            for(CConsumeItemPO item:cConsumeItemReturnDTOS){
                out = out.add(item.getMoney());
            }
            classifyAndConsumeReturnDTO.setMoney(out);
            list.add(classifyAndConsumeReturnDTO);
        }
        list = list.stream().sorted(Comparator.comparing(ClassifyAndConsumeReturnDTO::getMoney))
                .collect(Collectors.toList());
        return list;

    }
}
