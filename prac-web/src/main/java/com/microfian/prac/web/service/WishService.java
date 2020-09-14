package com.microFian.prac.web.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.microFian.prac.web.entity.Wish;
import com.microFian.prac.web.request.ReqWish;
import com.microFian.prac.web.response.ResWish;
import com.microFian.prac.web.response.Result;
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


    int  updateWish(ReqWish reqWish) ;



}
