package com.example;

public class BeanFactory {
    // 2. 자기 자신 인스턴스 참조하는 static 필드 선언
    private static BeanFactory instance = new BeanFactory();
    // 1. private 생성자를 생성, 외부에선 인스턴스 생성 못함
    private BeanFactory(){
    }

    // 3. 2번에서 생성한 인스터를 반환하는 static 메소드 생성
    public static BeanFactory getInstance(){
        return instance;
    }

    public Bus getBus(){
        return new Bus();
    }
}
