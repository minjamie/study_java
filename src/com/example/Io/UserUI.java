package com.example.Io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class UserUI {
    private BufferedReader br;

    public UserUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu(){
        System.out.println("1.회원등록");
        System.out.println("2.회원목록");
        System.out.println("3.회원수정");
        System.out.println("4.회원삭제");
        System.out.println("5.종료");
        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return menuId;
    }

    public User regUser(){
        try {
            System.out.println("email 입력");
            String email = br.readLine();
            System.out.println("이름 입력");
            String name = br.readLine();
            System.out.println("생년월일 입력");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear);

            User user = new User(email, name, birthYear);
            return user;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void printUserList(Iterator<User> iter){
        System.out.println("email  이름  생년월일");
        while (iter.hasNext()){
            User user = iter.next();
            System.out.print(user.getEmail());
            System.out.print("  ");
            System.out.print(user.getName());
            System.out.print("  ");
            System.out.print(user.getBirthYear());
            System.out.println("");
         }
    }

    public String inputUserEmail(){
        System.out.println("수정 email");
        String email = "";
        try {
            email = br.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return email;
    }

    public User inputUser(String email){
        try {
            System.out.println(email+ "정보 수정");
            System.out.println("이름 입력");
            String name = br.readLine();
            System.out.println("생년월일 입력");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear);

            User user = new User(email, name, birthYear);
            return user;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
