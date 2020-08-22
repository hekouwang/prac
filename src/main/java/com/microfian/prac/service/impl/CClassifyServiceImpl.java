package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.DTO.ClassifyChildrenVo;
import com.microfian.prac.request.ReqClassify;
import com.microfian.prac.response.ResClassify;
import com.microfian.prac.response.ResClassifyVo;
import com.microfian.prac.entity.Classify;
import com.microfian.prac.mapper.CClassifyPOMapper;
import com.microfian.prac.response.Result;
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
    public List<Classify> selClassify(CClassifyDTO cClassifyDTO) {

        return cClassifyPOMapper.selCClassify(cClassifyDTO);

    }

    @Override
    public List<ResClassifyVo> selClassifyByGroup(CClassifyDTO cClassifyDTO) {

        List<ResClassifyVo> list=new ArrayList<>();
        cClassifyDTO.setParentId(0);

        List<Classify> cClassifyPOS = cClassifyPOMapper.selCClassify(cClassifyDTO);
        if(CollectionUtils.isEmpty(cClassifyPOS)) {
            return list;
        }

        for(Classify cClassifyPO:cClassifyPOS){
            ResClassifyVo classifyVo=new ResClassifyVo();
            classifyVo.setValue(cClassifyPO.getId());
            classifyVo.setId(cClassifyPO.getId());
            classifyVo.setParentId(cClassifyPO.getParentId());
            classifyVo.setLabel(cClassifyPO.getClassifyName());
            List<ClassifyChildrenVo> list1=new ArrayList<>();
            cClassifyDTO.setParentId(cClassifyPO.getId());
            List<Classify> cClassifyPOS1 = cClassifyPOMapper.selCClassify(cClassifyDTO);
            if(!CollectionUtils.isEmpty(cClassifyPOS1)){
                for(Classify cClassifyPO1:cClassifyPOS1){
                    ClassifyChildrenVo classifyChildrenVo=new ClassifyChildrenVo();
                    classifyChildrenVo.setLabel(cClassifyPO1.getClassifyName());
                    classifyChildrenVo.setValue(cClassifyPO1.getId());
                    classifyChildrenVo.setId(cClassifyPO1.getId());
                    classifyChildrenVo.setParentId(cClassifyPO1.getParentId());
                    list1.add(classifyChildrenVo);
                }
            }
            classifyVo.setChildren(list1);

            list.add(classifyVo);
        }

        return list;
    }

    @Override
    public Result<List<Classify>> getByIdOrParentId(ReqClassify reqClassify) {

        Result<List<Classify>> result=new Result<>();
        List<Classify> classifyList=new ArrayList<>() ;
        if(null ==reqClassify){
            return result;
        }
        QueryWrapper<Classify> queryWrapper=new QueryWrapper<>();

        if(0==reqClassify.getParentId()){
            queryWrapper.eq("parent_id",reqClassify.getId());
        }else {
            queryWrapper.eq("id",reqClassify.getId());
        }
        List<Classify> classifies = cClassifyPOMapper.selectList(queryWrapper);
         return Result.success(classifies);
    }
}
