package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.entity.CClassifyPO;
import com.microfian.prac.mapper.CClassifyPOMapper;
import com.microfian.prac.service.CClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CClassifyServiceImpl  implements CClassifyService {

    @Autowired
    private CClassifyPOMapper cClassifyPOMapper;

    @Override
    public List<CClassifyPO> selClassify(CClassifyDTO cClassifyDTO) {
        return cClassifyPOMapper.selCClassify(cClassifyDTO);
    }
}
