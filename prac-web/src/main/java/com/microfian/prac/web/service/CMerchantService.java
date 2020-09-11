package com.microfian.prac.web.service;


import com.microfian.prac.web.entity.CMerchantPO;

import java.util.List;

public interface CMerchantService {

    public int addMerchant(CMerchantPO cMerchantPO);

    public int updateMerchant(CMerchantPO cMerchantPO);

    public List<CMerchantPO> selectMerchant(CMerchantPO cMerchantPO);
}
