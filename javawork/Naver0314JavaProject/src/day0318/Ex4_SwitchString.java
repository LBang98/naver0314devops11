package day0318;

import java.util.Scanner;

public class Ex4_SwitchString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String color;
        System.out.println("영문으로 색상 입력하기");
        color = sc.nextLine();

        //switch 에서 문자열도 가능(JDK8부터)
        switch (color){
            case "red":
                System.out.println("빨강색");
                break;
            case "GREEN":
            case "green":
                System.out.println("초록색");
                break;
            case "pink":
                System.out.println("분홍색");
                break;
            default:
                System.out.println("빨강, 초록, 분홍 이외의 색!");
        }
    }
}
