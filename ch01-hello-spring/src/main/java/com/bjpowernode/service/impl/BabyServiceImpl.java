package com.bjpowernode.service.impl;

import com.bjpowernode.service.BabyService;

public class BabyServiceImpl implements BabyService {

    public BabyServiceImpl(){
        System.out.println("BabyServiceImpl的无参数构造方法执行了！");
    }

    @Override
    public void specialService() {
        System.out.println("Special service has been made!");
    }
}
