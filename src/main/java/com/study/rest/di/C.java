package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    @Autowired(required = false)
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메소드 호출");
        d.dCall();
    }
}
