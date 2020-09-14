package com.microFian.prac.web.service;


import com.microFian.prac.web.entity.CProjectPO;

import java.util.List;

public interface CProjectService {

    List<CProjectPO> selectProject(CProjectPO cProjectPO);
}
