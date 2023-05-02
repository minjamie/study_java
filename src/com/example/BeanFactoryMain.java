package com.example;

public class BeanFactoryMain  {
    // 팩토리 메소드 패턴 - 복잡한 생성 과정 숨기고 완성된 인스턴스만 반환
    public static void main(String[] args) {
        BeanFactory bf1 = BeanFactory.getInstance();
        BeanFactory bf2 = BeanFactory.getInstance();
        if(bf1==bf2){
            System.out.println("bf1==bf2");
        }

        Bus b1 = bf1.getBus();
        Bus b2 = bf1.getBus();
        // 객체 생성을 대신해주는 팩토리 패턴
    }
}
