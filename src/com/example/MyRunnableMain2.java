package com.example;

public class MyRunnableMain2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        RunnableExecute re = new RunnableExecute();
        // 이름 없는 익명 클래스를 람다 인터페이스로 대체 가능 - 메소드 하나만 가지고 있는 인터페이스
        re.execute(()->{
            System.out.println("hi");
        });
    }
}
