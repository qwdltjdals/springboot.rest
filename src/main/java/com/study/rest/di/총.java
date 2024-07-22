package com.study.rest.di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class 총 implements 무기{

    @Override // ctrl + i
    public void 공격() {
        System.out.println("총을 발사합니다.");
    }
}
