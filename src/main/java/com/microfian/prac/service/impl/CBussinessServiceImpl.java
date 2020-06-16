package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountItemPO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.entity.CConsumeItemPO;
import com.microfian.prac.mapper.CAccountItemPOMapper;
import com.microfian.prac.mapper.CAccountPOMapper;
import com.microfian.prac.mapper.CConsumeItemPOMapper;
import com.microfian.prac.service.CBussinessService;
import com.microfian.prac.util.LocalStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class CBussinessServiceImpl implements CBussinessService {

    @Autowired
    private CAccountItemPOMapper cAccountItemPOMapper;

    @Autowired
    private CAccountPOMapper cAccountPOMapper;

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;


    @Override
    @Transactional
    public Object addOneExpand(CConsumeItemDTO cConsumeItemDTO,CAccountPO cAccountPO) {


        //1 新增一条消费记录
        CConsumeItemPO cConsumeItemPO = new CConsumeItemPO();
        BeanUtils.copyProperties(cConsumeItemDTO,cConsumeItemPO);
        cConsumeItemPO.setId(LocalStringUtil.getUUID());
        cConsumeItemPO.setIsAvailable(1);
        cConsumeItemPO.setIsDeleted(0);
        cConsumeItemPOMapper.insert(cConsumeItemPO);

        //2 账户变动
        if(cAccountPO.getAccountType()==1){
            cAccountPO.setBalance(cAccountPO.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            cAccountPO.setBalance(cAccountPO.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        cAccountPO.setUpdateTime(time);
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

        return null;
    }

    @Override
    public Object tranferAccount(CConsumeItemDTO cConsumeItemDTO,CAccountPO sourceAccount,CAccountPO targetAccount) {
        return null;
    }

    @Override
    public Object addOneIncome(CConsumeItemDTO cConsumeItemDTO,CAccountPO sourceAccount) {
        return null;
    }
}
