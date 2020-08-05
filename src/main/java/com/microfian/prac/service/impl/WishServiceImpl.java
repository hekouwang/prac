package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.Wish;
import com.microfian.prac.mapper.WishMapper;
import com.microfian.prac.request.ReqWish;
import com.microfian.prac.response.ResWish;
import com.microfian.prac.response.Result;
import com.microfian.prac.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-01
 */
@Service
public class WishServiceImpl extends ServiceImpl<WishMapper, Wish> implements WishService {


    @Autowired
    private WishMapper wishMapper;

    @Override
    public Result<List<ResWish>> listWishPage(ReqWish reqWish) {

        Result<List<ResWish>> result=new Result<>();
        IPage<Wish> iPage=new Page<>();
        iPage.setCurrent(reqWish.getCurrent());
        iPage.setSize(reqWish.getPageSize());
        QueryWrapper<Wish> queryWrapper=new QueryWrapper<>();
        IPage<Wish> page = page(iPage, queryWrapper);
        return result;

    }
}
