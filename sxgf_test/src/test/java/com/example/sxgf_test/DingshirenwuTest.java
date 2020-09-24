package com.example.sxgf_test;

import com.example.controller.Dingshirenwu;
import com.example.service.UserSerice;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class DingshirenwuTest {



    @Test
    void aaa() {
Dingshirenwu dingshirenwu=new Dingshirenwu();
dingshirenwu.aaa();

    }
}