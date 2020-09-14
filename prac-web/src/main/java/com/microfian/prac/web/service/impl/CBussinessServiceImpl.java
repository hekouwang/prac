package com.microFian.prac.web.service.impl;


import com.microFian.prac.web.DTO.CConsumeItemDTO;
import com.microFian.prac.web.entity.Account;
import com.microFian.prac.web.entity.CAccountItemPO;
import com.microFian.prac.web.entity.ConsumeItem;
import com.microFian.prac.web.mapper.AccountMapper;
import com.microFian.prac.web.mapper.CAccountItemPOMapper;
import com.microFian.prac.web.mapper.CConsumeItemPOMapper;
import com.microFian.prac.web.service.CBussinessService;
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
    private AccountMapper accountMapper;

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;


    @Override
    @Transactional
    public Object addOneExpand(CConsumeItemDTO cConsumeItemDTO, Account account) {


        //1 新增一条消费记录
        ConsumeItem consumeItem = new ConsumeItem();
        BeanUtils.copyProperties(cConsumeItemDTO, consumeItem);
        consumeItem.setIsAvailable(1);
        consumeItem.setIsDeleted(0);
        cConsumeItemPOMapper.insert(consumeItem);

        //2 账户变动
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
        cAccountItemPO.setRemark("前:"+account.getBalance().toString()+",");

        if(account.getAccountType()==1){
            account.setBalance(account.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            account.setBalance(account.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        cAccountItemPO.setRemark(cAccountItemPO.getRemark()+"后:"+account.getBalance());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        account.setUpdateTime(time);
        accountMapper.updateByPrimaryKey(account);

        //3 新增一条账户变动记录
        cAccountItemPO.setIsAvailable(1);
        cAccountItemPO.setIsDeleted(0);
        cAccountItemPO.setType(1);
        cAccountItemPO.setCreateTime(cConsumeItemDTO.getCreateTime());
        cAccountItemPO.setMoney(cConsumeItemDTO.getMoney());
        cAccountItemPO.setMerchantId(cConsumeItemDTO.getMerchantId());
        cAccountItemPO.setProjectId(cConsumeItemDTO.getProjectId());
        cAccountItemPO.setAccountId(cConsumeItemDTO.getSourceAccount());
        cAccountItemPOMapper.insert(cAccountItemPO);

        return null;
    }

    @Override
    @Transactional
    public Object tranferAccount(CConsumeItemDTO cConsumeItemDTO,Account sourceAccount,Account targetAccount) {

        //1 源账户扣减
        String remark="前:"+sourceAccount.getBalance()+",";
        if(sourceAccount.getAccountType()==1){
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            sourceAccount.setBalance(sourceAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        remark=remark+"后:"+sourceAccount.getBalance();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        sourceAccount.setUpdateTime(new Date());
        accountMapper.updateByPrimaryKey(sourceAccount);

        //2 目标账户增加
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
        String str="前:"+targetAccount.getBalance().toString()+",";
        if(targetAccount.getAccountType()==1){
            targetAccount.setBalance(targetAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }else {
            targetAccount.setBalance(targetAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }
        str=str+"后:"+targetAccount.getBalance();
        String time1 = format0.format(new Date());
//        targetAccount.setUpdateTime(new Date());
        accountMapper.updateByPrimaryKey(targetAccount);

        //3 源账户增加一条记录

        cAccountItemPO.setIsAvailable(1);
        cAccountItemPO.setIsDeleted(0);
        cAccountItemPO.setType(1);
        cAccountItemPO.setCreateTime(cConsumeItemDTO.getCreateTime());
        cAccountItemPO.setMoney(cConsumeItemDTO.getMoney());
        cAccountItemPO.setMerchantId(cConsumeItemDTO.getMerchantId());
        cAccountItemPO.setProjectId(cConsumeItemDTO.getProjectId());
        cAccountItemPO.setAccountId(cConsumeItemDTO.getSourceAccount());
        cAccountItemPO.setRemark(remark);
        cAccountItemPOMapper.insert(cAccountItemPO);


        //4 目标账户增加一条记录
        cAccountItemPO.setType(2);
        cAccountItemPO.setRemark(str);
        cAccountItemPO.setAccountId(cConsumeItemDTO.getTargetAccount());
        cAccountItemPOMapper.insert(cAccountItemPO);

        //5 增加一条转账记录
        ConsumeItem consumeItem = new ConsumeItem();
        BeanUtils.copyProperties(cConsumeItemDTO, consumeItem);
//        consumeItem.setId(LocalStringUtil.getUUID());
        consumeItem.setConsumeType(3);
        consumeItem.setIsAvailable(1);
        consumeItem.setIsDeleted(0);
        cConsumeItemPOMapper.insert(consumeItem);
        return null;
    }

    @Override
    @Transactional
    public Object addOneIncome(CConsumeItemDTO cConsumeItemDTO,Account sourceAccount) {

        //1 新增一条收入记录
        ConsumeItem consumeItem = new ConsumeItem();
        BeanUtils.copyProperties(cConsumeItemDTO, consumeItem);
//        consumeItem.setId(LocalStringUtil.getUUID());
        consumeItem.setIsAvailable(1);
        consumeItem.setIsDeleted(0);
        cConsumeItemPOMapper.insert(consumeItem);

        //2 账户变动
        String str="前:"+sourceAccount.getBalance().toString()+",";
        if(sourceAccount.getAccountType()==1){
            sourceAccount.setBalance(sourceAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }else {
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }
        str=str+"后:"+sourceAccount.getBalance();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        sourceAccount.setUpdateTime(time);
        accountMapper.updateByPrimaryKey(sourceAccount);


        //3 新增一条账户变动记录
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
        cAccountItemPO.setIsAvailable(1);
        cAccountItemPO.setIsDeleted(0);
        cAccountItemPO.setType(2);
        cAccountItemPO.setCreateTime(cConsumeItemDTO.getCreateTime());
        cAccountItemPO.setMoney(cConsumeItemDTO.getMoney());
        cAccountItemPO.setMerchantId(cConsumeItemDTO.getMerchantId());
        cAccountItemPO.setProjectId(cConsumeItemDTO.getProjectId());
        cAccountItemPO.setAccountId(cConsumeItemDTO.getSourceAccount());
        cAccountItemPO.setRemark(str);
        cAccountItemPOMapper.insert(cAccountItemPO);

        return null;
    }
}
