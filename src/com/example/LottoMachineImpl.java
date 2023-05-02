package com.example;
// 인터페이스 구현하게 되면 반드시 인터페이스가 가진 메소드를 오버라이딩 할 필요 있음
public class LottoMachineImpl implements LottoMachine{
    private Ball[] balls;
    @Override
    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }

    @Override
    public void mix() {
        for (int i = 0; i < 10000; i++) {
            int x1 = (int)(Math.random() * LottoMachine.MAX_BALL_COUNT);
            int x2 = (int)(Math.random() * LottoMachine.MAX_BALL_COUNT);
            if(x1!= x2) {
                Ball tmp = balls[x1]; // 값을 치환 시엔 type의 임시 변수 필요
                balls[x1] = balls[x2];
                balls[x2] = tmp;
            }
        }
    }

    @Override
    public Ball[] getBalls() {
        Ball[] result = new Ball[LottoMachine.RETURN_BALL_COUNT];
        for (int i = 0; i <result.length ; i++) {
            result[i] = balls[i];
        }
        return result;
    }
}
