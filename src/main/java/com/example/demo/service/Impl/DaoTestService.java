package com.example.demo.service.Impl;

import com.example.demo.dao.IDaoTest;
import com.example.demo.service.IDaoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DaoTestService implements IDaoTestService {

    @Autowired
    private IDaoTest daoTest;

    @Override
    @Transactional
    public int queryDataCount() {
        int a = daoTest.queryDataCount();
//        a = a / 0;
        System.out.println("方法执行中");
        return a;
    }
}
