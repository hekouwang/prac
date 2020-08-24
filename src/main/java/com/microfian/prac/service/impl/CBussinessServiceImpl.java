package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountItemPO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.entity.ConsumeItem;
import com.microfian.prac.mapper.CAccountItemPOMapper;
import com.microfian.prac.mapper.AccountMapper;
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
    private AccountMapper AccountMapper;

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;


    @Override
    @Transactional
    public Object addOneExpand(CConsumeItemDTO cConsumeItemDTO,Account Account) {


        //1 新增一条消费记录
        ConsumeItem consumeItem = new ConsumeItem();
        BeanUtils.copyProperties(cConsumeItemDTO, consumeItem);
        consumeItem.setIsAvailable(1);
        consumeItem.setIsDeleted(0);
        cConsumeItemPOMapper.insert(consumeItem);

        //2 账户变动

        if(Account.getAccountType()==1){
            Account.setBalance(Account.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            Account.setBalance(Account.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        account.setUpdateTime(time);
        AccountMapper.updateByPrimaryKey(Account);

        //3 新增一条账户变动记录
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
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
        if(sourceAccount.getAccountType()==1){
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }else {
            sourceAccount.setBalance(sourceAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        sourceAccount.setUpdateTime(new Date());
        AccountMapper.updateByPrimaryKey(sourceAccount);

        //2 目标账户增加
        if(targetAccount.getAccountType()==1){
            targetAccount.setBalance(targetAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }else {
            targetAccount.setBalance(targetAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }
        String time1 = format0.format(new Date());
//        targetAccount.setUpdateTime(new Date());
        AccountMapper.updateByPrimaryKey(targetAccount);

        //3 源账户增加一条记录
        CAccountItemPO cAccountItemPO = new CAccountItemPO();
        cAccountItemPO.setIsAvailable(1);
        cAccountItemPO.setIsDeleted(0);
        cAccountItemPO.setType(1);
        cAccountItemPO.setCreateTime(cConsumeItemDTO.getCreateTime());
        cAccountItemPO.setMoney(cConsumeItemDTO.getMoney());
        cAccountItemPO.setMerchantId(cConsumeItemDTO.getMerchantId());
        cAccountItemPO.setProjectId(cConsumeItemDTO.getProjectId());
        cAccountItemPO.setAccountId(cConsumeItemDTO.getSourceAccount());
        cAccountItemPOMapper.insert(cAccountItemPO);


        //4 目标账户增加一条记录
        cAccountItemPO.setType(2);
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
        if(sourceAccount.getAccountType()==1){
            sourceAccount.setBalance(sourceAccount.getBalance().add(cConsumeItemDTO.getMoney()));
        }else {
            sourceAccount.setBalance(sourceAccount.getBalance().subtract(cConsumeItemDTO.getMoney()));
        }
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
//        sourceAccount.setUpdateTime(time);
        AccountMapper.updateByPrimaryKey(sourceAccount);


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
        cAccountItemPOMapper.insert(cAccountItemPO);

        return null;
    }
}
