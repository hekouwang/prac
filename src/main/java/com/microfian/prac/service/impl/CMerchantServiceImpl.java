package com.microfian.prac.service.impl;

import com.microfian.prac.entity.CMerchantPO;
import com.microfian.prac.mapper.CMerchantPOMapper;
import com.microfian.prac.service.CMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CMerchantServiceImpl implements CMerchantService {

    @Autowired
    CMerchantPOMapper cMerchantPOMapper;

    @Override
    public int addMerchant(CMerchantPO cMerchantPO) {
        cMerchantPO.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        cMerchantPO.setIsAvailable(1);
        cMerchantPO.setIsDeleted(0);
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        cMerchantPO.setCreateTime(time);
        return cMerchantPOMapper.insert(cMerchantPO);
    }

    @Override
    public int updateMerchant(CMerchantPO cMerchantPO) {
        return 0;
    }

    @Override
    public List<CMerchantPO> selectMerchant(CMerchantPO cMerchantPO) {
        return null;
    }
}
