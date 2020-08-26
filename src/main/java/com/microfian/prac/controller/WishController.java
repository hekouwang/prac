package com.microfian.prac.controller;


import com.microfian.prac.request.ReqWish;
import com.microfian.prac.response.Result;
import com.microfian.prac.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author hekouwang
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/wish")
public class WishController {

    @Autowired
    private WishService wishService;

    @PostMapping(value = "/listWish")
    public Object listAccount(@RequestBody ReqWish reqWish) {

        try {
            return wishService.listWishPage(reqWish);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    @PostMapping(value = "/addWish")
    public Object addWish(@RequestBody ReqWish reqWish) {

        try {
            return wishService.addWish(reqWish);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }
}
