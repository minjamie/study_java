package com.example;

import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) throws Exception{
//        Bus b1= new Bus();
//        b1.a();


        // className에 해당하는 클래스 정보를 CLASSPATH에 읽어들임
        // 그 정보를 claszz가 참조


        //Java Reflection (자바 리플렉션) - 클래스 로더를 이용하여 인스턴스 생성
        //문자열로 된 메소드 이름만 갖고 클래스를 실행할 수 있는 방법이 있다는 것을 기억
        String className = "com.example.Bus";
        Class clazz = Class.forName(className);
        Object o = clazz.newInstance();
//        Car b = (Car) o;
//        b.a();
        Method m = clazz.getDeclaredMethod("a", null); // a()메소드 정보를 갖고 있는 Method를 반환
        m.invoke(o, null); // m이라는 정보를 이용하여 실행 - Object o가 참조하는 객체의 m 메소드 실행

        // 클래스가 가진 필드나 메서드에 대한 정보를 구함
//        Method[] declareMethods = clazz.getDeclaredMethods();
//        for(Method m:declareMethods){
//            System.out.println(m.getName());
//        }
    }
}
