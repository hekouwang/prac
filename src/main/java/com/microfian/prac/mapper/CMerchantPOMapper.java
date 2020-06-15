package com.microfian.prac.mapper;


import com.microfian.prac.entity.CMerchantPO;
import org.springframework.stereotype.Repository;

@Repository
public interface CMerchantPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CMerchantPO record);

    int insertSelective(CMerchantPO record);

    CMerchantPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CMerchantPO record);

    int updateByPrimaryKey(CMerchantPO record);
}