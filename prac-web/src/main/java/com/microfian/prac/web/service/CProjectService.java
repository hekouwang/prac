package com.microfian.prac.web.service;


import com.microfian.prac.web.entity.CProjectPO;

import java.util.List;

public interface CProjectService {

    List<CProjectPO> selectProject(CProjectPO cProjectPO);
}
