package com.microfian.prac.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.entity.Wish;
import com.microfian.prac.mapper.WishMapper;
import com.microfian.prac.request.ReqWish;
import com.microfian.prac.response.ResWish;
import com.microfian.prac.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-01
 */

@Component
public interface WishService extends IService<Wish> {

    Result<List<ResWish>>  listWishPage(ReqWish reqWish) throws ParseException;


    int  addWish(ReqWish reqWish) ;



}
