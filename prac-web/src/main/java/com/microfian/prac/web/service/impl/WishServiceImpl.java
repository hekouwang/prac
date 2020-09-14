package com.microFian.prac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microFian.prac.web.entity.Account;
import com.microFian.prac.web.entity.Wish;
import com.microFian.prac.web.mapper.AccountMapper;
import com.microFian.prac.web.mapper.WishMapper;
import com.microFian.prac.web.request.ReqWish;
import com.microFian.prac.web.response.ResWish;
import com.microFian.prac.web.response.Result;
import com.microFian.prac.web.service.WishService;
import com.microFian.prac.web.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-01
 */
@Service
public class WishServiceImpl extends ServiceImpl<WishMapper, Wish> implements WishService {


    @Autowired
    private WishMapper wishMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Result<List<ResWish>> listWishPage(ReqWish reqWish) throws ParseException {

        Result<List<ResWish>> result=new Result<>();
        IPage<Wish> iPage=new Page<>();
        iPage.setCurrent(reqWish.getCurrent());
        iPage.setSize(reqWish.getPageSize());
        QueryWrapper<Wish> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotEmpty(reqWish.getStatus())){
            queryWrapper.eq("status",reqWish.getStatus());
        }
        if(StringUtils.isNotEmpty(reqWish.getName())){
            queryWrapper.like("name",reqWish.getName());
        }
        IPage<Wish> page = wishMapper.selectPage(iPage, queryWrapper);
        List<Wish> records = page.getRecords();
        List<ResWish> resWishList=new ArrayList<>();
        if(CollectionUtils.isEmpty(records)){
            return result;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for(Wish wish:records){
                ResWish resWish=new ResWish();
                BeanUtils.copyProperties(wish,resWish);
                Account account = accountMapper.selectById(resWish.getAccountId());
                resWish.setBalance(account.getBalance());
                resWish.setApartDays((resWish.getTotalMoney().subtract(resWish.getBalance()))
                        .divide(resWish.getDayMoney(),2, BigDecimal.ROUND_HALF_UP)
                        .setScale( 0, BigDecimal.ROUND_UP ).longValue());
                resWish.setAccomplishTime(DateUtil.getNextDate(formatter.format(new Date()),
                        resWish.getApartDays().intValue(), Calendar.DATE,"yyyy-MM-dd"));
                resWishList.add(resWish);
//                resWish.setApartDays(DateUtil.daysBetween(resWish.getAccomplishTime(),resWish.getCreateTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setTotal(page.getTotal());
        result.setMsg("成功");
        result.setCode(20000);
        result.setData(resWishList);
        return result;

    }

    @Override
    public int addWish(ReqWish reqWish) {

        Wish wish=new Wish();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        BeanUtils.copyProperties(reqWish,wish);
        wish.setCreateTime(formatter.format(new Date()));
        wish.setIsAvailable(1);
        wish.setIsDeleted(0);
        wish.setStatus("doing");
        return wishMapper.insert(wish);

    }

    @Override
    public int updateWish(ReqWish reqWish) {

        Wish wish=new Wish();
        BeanUtils.copyProperties(reqWish,wish);
        return wishMapper.updateById(wish);

    }
}
