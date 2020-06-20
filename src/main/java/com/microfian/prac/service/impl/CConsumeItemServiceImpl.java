package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.DTO.ResCConsumeItem;
import com.microfian.prac.mapper.CConsumeItemPOMapper;
import com.microfian.prac.service.CConsumeItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CConsumeItemServiceImpl implements CConsumeItemService {

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;

    @Override
    public List<ResCConsumeItem> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO) {
        List<CConsumeItemReturnDTO> list= cConsumeItemPOMapper.selByCondition(cConsumeItemDTO);
        Map<String,List<CConsumeItemReturnDTO>> map =list.stream().collect(
                Collectors.groupingBy(CConsumeItemReturnDTO::getDay, LinkedHashMap::new, Collectors.toList()));
        List<ResCConsumeItem> resCConsumeItemList=new ArrayList<>();
        for (Map.Entry<String, List<CConsumeItemReturnDTO>> entry : map.entrySet()){
            ResCConsumeItem resCConsumeItem=new ResCConsumeItem();
            resCConsumeItem.setDate(entry.getKey());
            BigDecimal in=new BigDecimal("0");
            BigDecimal out=new BigDecimal("0");
            List<CConsumeItemReturnDTO> entryList=entry.getValue();
            for(CConsumeItemReturnDTO cConsumeItemReturnDTO:entryList){
                if(cConsumeItemReturnDTO.getConsumeType()==1){
                    out=out.add(cConsumeItemReturnDTO.getMoney());
                }else if(cConsumeItemReturnDTO.getConsumeType()==2){
                    in=in.add(cConsumeItemReturnDTO.getMoney());
                }
            }
            //按提交时间降序--stream写法
            entryList = entryList.stream().sorted(Comparator.comparing(CConsumeItemReturnDTO::getCreateTime).reversed()).collect(Collectors.toList());//根据创建时间倒排

            resCConsumeItem.setIn(in);
            resCConsumeItem.setOut(out);
            resCConsumeItem.setCConsumeItemReturnDTOList(entryList);
            resCConsumeItemList.add(resCConsumeItem);
        }
        return resCConsumeItemList;
    }
}
