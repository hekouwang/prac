package com.microFian.prac.web.controller;

import com.microFian.prac.web.DTO.CAccountDTO;
import com.microFian.prac.web.entity.Account;
import com.microFian.prac.web.request.ReqAccount;
import com.microFian.prac.web.response.Result;
import com.microFian.prac.web.service.CAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class CAccountController {

    @Autowired
    private CAccountService cAccountService;

    @PostMapping(value = "/addAccount")
    public Object addAccount(@RequestBody Account Account){
        return cAccountService.addAccount(Account);
    }

    @PostMapping(value = "/listAccount")
    public Object listAccount(@RequestBody CAccountDTO cAccountDTO) {
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cAccountService.selAccount(cAccountDTO));
        return map;
    }

    /**
     * 分组查询账户(新增时用到)
     * @param cAccountDTO
     * @return
     */
    @PostMapping(value = "/listAccountByGroupSelect")
    public Object listAccountByGroupSelect(@RequestBody CAccountDTO cAccountDTO) {

        try {
            return cAccountService.listAccountByGroupSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();

    }

    /**
     * 分组查询账户
     * @param cAccountDTO
     * @return
     */
    @PostMapping(value = "/listAccountByGroup")
    public Object listAccountByGroup(@RequestBody CAccountDTO cAccountDTO) {

        try {
            return cAccountService.listAccountByGroup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();

    }

    /**
     * 分组查询账户
     * @param reqAccount
     * @return
     */
    @PostMapping(value = "/getAccountByIdOrParentId")
    public Object getAccountByIdOrParentId(@RequestBody ReqAccount reqAccount) {

        try {
            return cAccountService.getByIdOrParentId(reqAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();

    }

    @PostMapping(value = "/listWishAccount")
    public Object listWishAccount(@RequestBody CAccountDTO cAccountDTO) {

        try {
            return cAccountService.listWishAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();

    }

}
