package com.example.Io;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/userDao.dat");
        UserService userService = new UserServiceInMemory(userDao.getUsers());


        while (true){
            int menuId = userUI.menu();
            if(menuId==5){
                userDao.saveUser(userService.getUsers());
                break;
            } else if (menuId == 1) {
                User user = userUI.regUser();
                userService.addUser(user);
                System.out.println("등록");
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputUserEmail();
                boolean isFindEmail = userService.exists(email);

                if (isFindEmail) {
                    User updatedUser = userUI.inputUser(email);
                    userService.updateUser(updatedUser);
                    System.out.println("수정");
                } else {
                    System.out.println("없음");
                }
            } else if (menuId == 4) {
                String email = userUI.inputUserEmail();
                boolean isFindEmail = userService.exists(email);

                if(isFindEmail) {
                    userService.deleteUser(email);
                    System.out.println("삭제");
                } else {
                    System.out.println("없음");
                }
            }
        }
    }
}
