package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.Wish;
import com.microfian.prac.mapper.CAccountPOMapper;
import com.microfian.prac.mapper.WishMapper;
import com.microfian.prac.request.ReqWish;
import com.microfian.prac.response.ResWish;
import com.microfian.prac.response.Result;
import com.microfian.prac.service.WishService;
import com.microfian.prac.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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
    private CAccountPOMapper cAccountPOMapper;

    @Override
    public Result<List<ResWish>> listWishPage(ReqWish reqWish) throws ParseException {

        Result<List<ResWish>> result=new Result<>();
        IPage<Wish> iPage=new Page<>();
        iPage.setCurrent(reqWish.getCurrent());
        iPage.setSize(reqWish.getPageSize());
        QueryWrapper<Wish> queryWrapper=new QueryWrapper<>();
        IPage<Wish> page = page(iPage, queryWrapper);
        List<Wish> records = page.getRecords();
        List<ResWish> resWishList=new ArrayList<>();
        if(CollectionUtils.isEmpty(records)){
            return result;
        }
        try {
            for(Wish wish:records){
                ResWish resWish=new ResWish();
                BeanUtils.copyProperties(wish,resWish);
//                cAccountPOMapper.s
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
        BeanUtils.copyProperties(reqWish,wish);
        wish.setCreateTime(new Date());
        return 0;
    }
}
