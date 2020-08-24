package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.mapper.AccountMapper;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.util.LocalStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CAccountServiceImpl implements CAccountService {


    @Autowired
    AccountMapper AccountMapper;


    @Override
    public int addAccount(Account account) {
        account.setIsAvailable(1);
//        account.setId(LocalStringUtil.getUUID());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        account.setCreateTime(time);
        account.setIsDeleted(0);
        return AccountMapper.insert(account);
    }

    @Override
    public Account selAccountById(String id) {
        return AccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Account> selAccount(CAccountDTO cAccountDTO) {
        return AccountMapper.selCAcount(cAccountDTO);
    }

    @Override
    public int updateAccount() {
        return 0;
    }

    @Override
    public List<Account> listAccount() {
        return null;
    }
}
