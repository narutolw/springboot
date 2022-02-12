package com.example.demo;

import com.example.demo.dao.IDaoTest;
import com.example.demo.service.IDaoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldDemo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IDaoTestService daoTestService;

    @ResponseBody
    @RequestMapping(path = "/hello")
    public String hello() {
        int i = daoTestService.queryDataCount();
        return i + "";
    }

}
