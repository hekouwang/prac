package com.microfian.prac.service;

import com.microfian.prac.entity.CProjectPO;

import java.util.List;

public interface CProjectService {

    List<CProjectPO> selectProject(CProjectPO cProjectPO);
}
