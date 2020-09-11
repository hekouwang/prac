package com.microfian.prac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microfian.prac.web.DTO.CClassifyDTO;
import com.microfian.prac.web.entity.Classify;
import com.microfian.prac.web.mapper.CClassifyPOMapper;
import com.microfian.prac.web.request.ReqClassify;
import com.microfian.prac.web.response.ResClassifyChildrenVo;
import com.microfian.prac.web.response.ResClassifyVo;
import com.microfian.prac.web.response.Result;
import com.microfian.prac.web.response.ResultEnum;
import com.microfian.prac.web.service.CClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CClassifyServiceImpl  implements CClassifyService {

    @Autowired
    private CClassifyPOMapper cClassifyPOMapper;

    @Override
    public Result addClassify(ReqClassify reqClassify) {

        Classify classify=new Classify();
        BeanUtils.copyProperties(reqClassify,classify);
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(new Date());
        if(null ==classify.getParentId()){
            classify.setParentId(0);
        }
        classify.setCreateTime(time);
        classify.setIsAvailable(1);
        classify.setIsDeleted(0);
        cClassifyPOMapper.insert(classify);
        return Result.success();

    }

    @Override
    public Result forbidClassify(ReqClassify reqClassify) {
        if(null==reqClassify || null==reqClassify.getId() || null==reqClassify.getIsAvailable()){
            return  Result.failure(ResultEnum.UNKNOWN_ERROR.getCode());
        }
        Classify classify=new Classify();
        BeanUtils.copyProperties(reqClassify,classify);
        cClassifyPOMapper.updateById(classify);
        return Result.success();
    }

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
            classifyVo.setName(cClassifyPO.getClassifyName());
            List<ResClassifyChildrenVo> list1=new ArrayList<>();
            cClassifyDTO.setParentId(cClassifyPO.getId());
            List<Classify> cClassifyPOS1 = cClassifyPOMapper.selCClassify(cClassifyDTO);
            if(!CollectionUtils.isEmpty(cClassifyPOS1)){
                for(Classify cClassifyPO1:cClassifyPOS1){
                    ResClassifyChildrenVo resClassifyChildrenVo =new ResClassifyChildrenVo();
                    resClassifyChildrenVo.setLabel(cClassifyPO1.getClassifyName());
                    resClassifyChildrenVo.setValue(cClassifyPO1.getId());
                    resClassifyChildrenVo.setId(cClassifyPO1.getId());
                    resClassifyChildrenVo.setName(cClassifyPO1.getClassifyName());
                    resClassifyChildrenVo.setParentId(cClassifyPO1.getParentId());
                    list1.add(resClassifyChildrenVo);
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
