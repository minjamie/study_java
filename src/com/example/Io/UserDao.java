package com.example.Io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 파일에서 유저 정보 저장 및 읽기
* */
public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    public void saveUser(Iterator<User> iter){
        List<User> users = new ArrayList<>();
        while (iter.hasNext()){
            User user = iter.next();
            users.add(user);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(users);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<User> getUsers(){
        File file = new File(filename);

        if(!file.exists()){
            return new ArrayList<>();
        }
        List<User> list = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            list = (List<User>)in.readObject();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
