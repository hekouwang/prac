package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountItemPO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.entity.CConsumeItemPO;
import com.microfian.prac.mapper.CAccountItemPOMapper;
import com.microfian.prac.mapper.CAccountPOMapper;
import com.microfian.prac.mapper.CConsumeItemPOMapper;
import com.microfian.prac.service.BussinessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BussinessServiceImpl implements BussinessService {

    @Autowired
    private CAccountItemPOMapper cAccountItemPOMapper;

    @Autowired
    private CAccountPOMapper cAccountPOMapper;

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;


    @Override
    public void addOneExpand(CConsumeItemDTO cConsumeItemDTO) {


        //1 新增一条消费记录
        CConsumeItemPO cConsumeItemPO = new CConsumeItemPO();
        BeanUtils.copyProperties(cConsumeItemDTO,cConsumeItemPO);
        cConsumeItemPOMapper.insert(cConsumeItemPO);

        //2 账户变动
        CAccountPO cAccountPO = cAccountPOMapper.selectByPrimaryKey(cConsumeItemDTO.getSourceAccount());
        if(null == cAccountPO){

        }
        if(cAccountPO.getAccountType()==1){
            cAccountPO.setBalance(cAccountPO.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            cAccountPO.setBalance(cAccountPO.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        cAccountPOMapper.updateByPrimaryKey(cAccountPO);

        //3 新增一条账户变动记录
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
        cAccountItemPO.setIsAvailable(1);
        cAccountItemPO.setIsDeleted(0);
        cAccountItemPO.setCreateTime(cConsumeItemDTO.getCreateTime());
        cAccountItemPO.setMoney(cConsumeItemDTO.getMoney());
        cAccountItemPO.setMerchantId(cConsumeItemDTO.getMerchantId());
        cAccountItemPO.setProjectId(cConsumeItemDTO.getProjectId());
        cAccountItemPO.setAccountId(cConsumeItemDTO.getSourceAccount());
        cAccountItemPOMapper.insert(cAccountItemPO);

    }
}
