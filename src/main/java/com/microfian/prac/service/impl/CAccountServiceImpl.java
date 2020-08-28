package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.mapper.AccountMapper;
import com.microfian.prac.response.Result;
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
    AccountMapper accountMapper;


    @Override
    public int addAccount(Account account) {

        account.setIsAvailable(1);
//        account.setId(LocalStringUtil.getUUID());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        account.setCreateTime(time);
        account.setIsDeleted(0);
        return accountMapper.insert(account);

    }

    @Override
    public Account selAccountById(String id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Account> selAccount(CAccountDTO cAccountDTO) {
        return accountMapper.selCAcount(cAccountDTO);
    }

    @Override
    public int updateAccount() {
        return 0;
    }

    @Override
    public List<Account> listAccount() {
        return null;
    }

    @Override
    public Result listWishAccount() {

        Result<List<Account>> result=new Result<>();
        QueryWrapper<Account> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("account_name","蚂蚁心愿");
        queryWrapper.eq("is_available",1);
        Account account = accountMapper.selectOne(queryWrapper);
        if(null ==account){
            return result;
        }
        QueryWrapper<Account> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("parent_account_id",account.getId());
        queryWrapper1.eq("is_available",1);
        queryWrapper1.orderByDesc("create_Time");
        List<Account> accountList = accountMapper.selectList(queryWrapper1);
        result.setData(accountList);
        result.setMsg("成功");
        result.setCode(20000);
        return result;
    }
}
