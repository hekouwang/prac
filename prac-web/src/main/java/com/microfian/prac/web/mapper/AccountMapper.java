package com.microfian.prac.web.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microfian.prac.web.DTO.CAccountDTO;
import com.microfian.prac.web.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper  extends BaseMapper<Account> {
    int deleteByPrimaryKey(String id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String id);

    List<Account> selCAcount(CAccountDTO cAccountDTO);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}