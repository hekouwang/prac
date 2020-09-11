package com.microfian.prac.web.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.web.entity.Wish;
import com.microfian.prac.web.request.ReqWish;
import com.microfian.prac.web.response.ResWish;
import com.microfian.prac.web.response.Result;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-01
 */

@Component
public interface WishService extends IService<Wish> {

    Result<List<ResWish>> listWishPage(ReqWish reqWish) throws ParseException;


    int  addWish(ReqWish reqWish) ;



}
