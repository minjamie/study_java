package com.example;

public class LottoMachineMain {
    public static void main(String[] args) {
        // 변수가 45개 필요 = Ball 인스턴스 45개 참조할 수 있는 배열 생성
        Ball[] balls = new Ball[LottoMachine.MAX_BALL_COUNT];

        for(int i = 0; i<LottoMachine.MAX_BALL_COUNT; i++){
            balls[i] = new Ball(i+1);
        }
        // LottoMachine 인스턴스 생성 - 인터페이스는 참조하는 레퍼런스는 가능
        LottoMachine lottoMachine = new LottoMachineImpl();
        lottoMachine.setBalls(balls);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getNumber());
        }
    }
}
