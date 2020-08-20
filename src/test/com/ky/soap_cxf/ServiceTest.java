package com.ky.soap_cxf;

import com.ky.soap_cxf.dao.CxfClient;
import com.ky.soap_cxf.service.UpAndDownMbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring.xml"})
public class ServiceTest {
    @Resource
    private UpAndDownMbService upAndDownMbService;

    @Test
    public void uploadAndDown() {
        upAndDownMbService.AllService();
    }
}