package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.DTO.ClassifyChildrenVo;
import com.microfian.prac.DTO.ClassifyVo;
import com.microfian.prac.entity.CClassifyPO;
import com.microfian.prac.mapper.CClassifyPOMapper;
import com.microfian.prac.service.CClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CClassifyServiceImpl  implements CClassifyService {

    @Autowired
    private CClassifyPOMapper cClassifyPOMapper;

    @Override
    public List<CClassifyPO> selClassify(CClassifyDTO cClassifyDTO) {

        return cClassifyPOMapper.selCClassify(cClassifyDTO);

    }

    @Override
    public List<ClassifyVo> selClassifyByGroup(CClassifyDTO cClassifyDTO) {

        List<ClassifyVo> list=new ArrayList<>();
        cClassifyDTO.setParentId(0);
        List<CClassifyPO> cClassifyPOS = cClassifyPOMapper.selCClassify(cClassifyDTO);
        if(!CollectionUtils.isEmpty(cClassifyPOS)) {
            return list;
        }

        for(CClassifyPO cClassifyPO:cClassifyPOS){
            ClassifyVo classifyVo=new ClassifyVo();
            classifyVo.setValue(cClassifyPO.getId());
            classifyVo.setLabel(cClassifyPO.getClassifyName());
            List<ClassifyChildrenVo> list1=new ArrayList<>();
            cClassifyDTO.setParentId(cClassifyPO.getId());
            List<CClassifyPO> cClassifyPOS1 = cClassifyPOMapper.selCClassify(cClassifyDTO);
            if(!CollectionUtils.isEmpty(cClassifyPOS1)){
                for(CClassifyPO cClassifyPO1:cClassifyPOS1){
                    ClassifyChildrenVo classifyChildrenVo=new ClassifyChildrenVo();
                    classifyChildrenVo.setLabel(cClassifyPO1.getClassifyName());
                    classifyChildrenVo.setValue(cClassifyPO1.getId());
                    list1.add(classifyChildrenVo);
                }
            }
            classifyVo.setChildren(list1);

            list.add(classifyVo);
        }

        return list;
    }
}
