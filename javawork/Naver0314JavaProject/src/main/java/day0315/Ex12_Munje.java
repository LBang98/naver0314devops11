package day0315;

import java.util.Scanner;

public class Ex12_Munje {
    public static void main(String[] args) {

        /*
        * 점수(score)를 입력받아
        * 점수가 90점 이상이면 "참 잘했어요!!"
        *      80점 이상이면 "수고했어요!"
        *      70점 이상이면 "조금 더 노력하세요!"
        *      그 나머지는 "재시험입니다!"
        *      메시지를 저장할 문자열 변수명 : msg
        * */

        Scanner sc = new Scanner(System.in);

        System.out.println("점수를 입력하세요");

        int score = sc.nextInt();
        String msg;

        msg = score >= 90?"참 잘했어요!!": score>= 80?"수고했어요!": score >= 70?"조금 더 노력하세요!":"재시험입니다!";

        System.out.println(msg);


    }
}
