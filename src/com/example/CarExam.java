package com.example;

public class CarExam {
    public static void main(String[] args) {
        // Car는 상속받고 싶지만 클래스는 만들고 싶지 않은 경우
        Car c1 = new Car(){
            @Override
            public void a() {
                System.out.println("이름없는 객체의 a()메소드 오버라이딩");
            }
        };
        // Car를 상속받는 이름없는 익명 클래스 생성
        c1.a();
    }
}
