package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.entity.Classify;
import com.microfian.prac.mapper.AccountMapper;
import com.microfian.prac.request.ReqAccount;
import com.microfian.prac.request.ReqClassify;
import com.microfian.prac.response.*;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.util.LocalStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Override
    public Result listAccountByGroup() {

        Result<List<ResAccountVo>> result=new Result<>();
        List<ResAccountVo> list=new ArrayList<>();
        QueryWrapper<Account> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("parent_account_id",0);
        List<Account> accountList = accountMapper.selectList(queryWrapper);
        if(org.apache.commons.collections.CollectionUtils.isEmpty(accountList)){
            return result;
        }
        for(Account account:accountList){
            ResAccountVo accountVo=new ResAccountVo();
            BigDecimal totalBalance=new BigDecimal(0);
            accountVo.setValue(account.getId());
            accountVo.setId(account.getId());
            accountVo.setParentId(account.getParentAccountId());
            accountVo.setLabel(account.getAccountName());
            accountVo.setName(account.getAccountName());
            List<ResAccountChildrenVo> list1=new ArrayList<>();
            QueryWrapper<Account> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("parent_account_id",accountVo.getId());
            List<Account> childrenAccountList = accountMapper.selectList(queryWrapper1);
            if(!CollectionUtils.isEmpty(childrenAccountList)){
                for(Account accountChildren:childrenAccountList){
                    ResAccountChildrenVo resAccountChildrenVo =new ResAccountChildrenVo();
                    resAccountChildrenVo.setLabel(accountChildren.getAccountName());
                    resAccountChildrenVo.setValue(accountChildren.getId());
                    resAccountChildrenVo.setId(accountChildren.getId());
                    resAccountChildrenVo.setName(accountChildren.getAccountName());
                    resAccountChildrenVo.setParentId(accountChildren.getParentAccountId());
                    totalBalance= totalBalance.add(accountChildren.getBalance());
                    list1.add(resAccountChildrenVo);
                }
            }
            accountVo.setTotalBalance(totalBalance);
            accountVo.setChildren(list1);

            list.add(accountVo);
        }
        result.setData(list);
        result.setCode(20000);
        result.setMsg("成功");
        return result;

    }

    @Override
    public Result<List<ResAccount>> getByIdOrParentId(ReqAccount reqAccount) {

        Result<List<ResAccount>> result=new Result<>();
        List<ResAccount> resAccountList=new ArrayList<>();
        List<Classify> classifyList=new ArrayList<>() ;
        if(null ==reqAccount){
            return result;
        }
        QueryWrapper<Account> queryWrapper=new QueryWrapper<>();
        if(0==reqAccount.getParentAccountId()){
            queryWrapper.eq("parent_account_id",reqAccount.getId());
        }else {
            queryWrapper.eq("id",reqAccount.getId());
        }
        List<Account> accountList = accountMapper.selectList(queryWrapper);
        for(Account account :accountList){
            ResAccount resAccount=new ResAccount();
            BeanUtils.copyProperties(account,resAccount);
            resAccountList.add(resAccount);
        }
        return Result.success(resAccountList);

    }
}
