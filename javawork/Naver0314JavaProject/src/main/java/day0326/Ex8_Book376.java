package day0326;

interface Tire{
    //추상 메서드
    void roll();

}

class HanKookTire implements Tire{
    @Override
    public void roll() {
        System.out.println("한국 타이어가 굴러갑니다");
    }
}

class KumhoTire implements Tire{
    @Override
    public void roll() {
        System.out.println("금호 타이어가 굴러갑니다");
    }
}

class Car{
    Tire tire1 = new HanKookTire();
    Tire tire2 = new KumhoTire();

    void run(){
        tire1.roll();
        tire2.roll();
    }
}

public class Ex8_Book376 {
    public static void main(String[] args) {

        //자동차 객체 생성
        Car myCar = new Car();

        //run()메서드 실행
        myCar.run();

        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();

        myCar.run();

    }
}
