package com.example.Io;

import java.util.Iterator;
import java.util.List;

public interface UserService {
    //등록
    public void addUser(User user);

    //수정
    public boolean updateUser(User user);

    //삭제
    public boolean deleteUser(String email);

    //모든 회원 반환
    public Iterator<User> getUsers();

    // email에 해당하는 회원정보있을 경우 0보다 큰 값 반환
    public boolean exists(String email);
}
