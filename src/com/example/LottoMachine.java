package com.example;
/*
1. 1-45까지 써 있는 ball을 로또 기계에 넣음
2. 로또 기계에 있는 볼을 섞음
3. 섞인 ball 중에  6개를 꺼냄
 */
public interface LottoMachine {
    int MAX_BALL_COUNT = 45;
    int RETURN_BALL_COUNT = 7;
    public void setBalls(Ball[] balls); // Ball[] ball 여러개 받ㅇㅁ
    public void mix();// 갖고 있는 ball을 섞음
    public Ball[] getBalls();

}
