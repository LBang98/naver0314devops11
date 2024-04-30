package day0315;

import java.util.Scanner;

public class Ex9_Munje {
    public static void main(String[] args) {

        /*
        *  백만단위의 금액(money)를 입력받은 후
        *  만원, 천원, 백원, 십원, 일원 단위로 몇개인지 출력하시오
        *  ex)
        *  금액 입력
        *  4567893
        *  만원 : 456장
        *  천원 : 7장
        *  백원 : 8개
        *  십원 : 9개
        *  일원 : 3개
        * */
        Scanner sc = new Scanner(System.in);

        System.out.println("금액을 입력하시오: ");
        int money = sc.nextInt();

        int m10000, m1000, m100, m10, m1;

        m10000 = money / 10000;
        m1000 = money % 10000 / 1000;
        m100 = money % 1000 / 100;
        m10 = money % 100 / 10;
        m1 = money % 10 / 1;

        System.out.println(m10000 + "장");
        System.out.println(m1000 + "장");
        System.out.println(m100 + "개");
        System.out.println(m10 + "개");
        System.out.println(m1 + "개");






    }
}
