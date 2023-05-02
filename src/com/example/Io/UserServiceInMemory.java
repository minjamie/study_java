package com.example.Io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserServiceInMemory implements UserService {
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        boolean deleteFlag = deleteUser(user.getEmail());
        if(deleteFlag){
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean exists(String email){
        if(findIdx(email) >= 0)
            return true;
        else
            return false;
    }


    public int findIdx(String email) {
        int findIdx = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                findIdx = i;
                break;
            }
        }
        return findIdx;
    }

    @Override
    public boolean deleteUser(String email) {
        int findIdx = findIdx(email);
        if(findIdx > -1){
            users.remove(findIdx);
            return true;
        } else {
            return false;
        }
    }

    //필드 users 정보 그대로 리턴
    // users 정보 복사 후 리턴
    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }
}
