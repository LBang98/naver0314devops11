package day0322;

import day0318.Ex1_Munje;
class Apple{

    String msg = "Happy Day!!"; // 인스턴스 멤버변수
    static String message = "오늘은 금요일"; //static 멤버변수(클래스 멤버변수)

}
class Banana{
    static int kor = 100;
    static int eng = 80;
    String name = "마이클";
}

public class Ex1_Object {
    //멤버 변수들
    String name = "홍길동"; //인스턴스 변수
    final static int Max = 100; //static 변수, final : 상수 지정, 값변경이 안됌

    public static void main(String[] args) {
        /*
        *   static 멤버 메서드는 static 멤버 변수나 멤버 메서드만
        *   접근이 가능하다
        *   일반 인스턴스 메서드나 변수를 접근하기 위해서 new로 생성 후
        *   그 변수를 이용해서 호출해야만 한다
        * */

        // System.out.println(name); //오류 발생
        System.out.println(Ex1_Object.Max); //static 변수는 클래스명.변수명
        System.out.println(Max); //같은 클래스명일 경우는 앞에 클래스명은 생략이 가능하다

        //name을 출력하려면 new 생성한 인스턴스 변수가 필요하다
        Ex1_Object ex = new Ex1_Object();
        //ex가 인스턴스 변수이다. 이 변수를 이용해야만 name이 접근이 가능하다
        System.out.println(ex.name);

        //Apple 이 가진 2개의 멤버변수를 출력해보세요
        Apple apple = new Apple();
        System.out.println(apple.msg);

        System.out.println(Apple.message);

        //Banana 클래스의 kor,eng 점수 출력하고 합계도 출력
        System.out.println("국어 점수: " + Banana.kor);
        System.out.println("영어 점수: " + Banana.eng);

        int sum = Banana.kor + Banana.eng;
        System.out.println("합계: " + sum);

        //Banana 클래스의 name 도 출력
        Banana banana = new Banana();
        System.out.println("이름: " + banana.name);

    }

}
