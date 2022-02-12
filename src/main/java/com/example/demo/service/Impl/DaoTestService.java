package com.example.demo.service.Impl;

import com.example.demo.dao.IDaoTest;
import com.example.demo.service.IDaoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoTestService implements IDaoTestService {

    @Autowired
    private IDaoTest daoTest;

    @Override
    public int queryDataCount() {
        return daoTest.queryDataCount();
    }
}
