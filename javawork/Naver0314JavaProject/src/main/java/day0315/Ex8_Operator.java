package day0315;

import java.util.Scanner;

public class Ex8_Operator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("두 개의 숫자 입력: ");

        int su1 = scanner.nextInt();
        int su2 = scanner.nextInt();

        System.out.println("더하기: " + (su1 + su2));
        System.out.println("빼기: " + (su1 - su2));
        System.out.println("곱하기: " + (su1 * su2));
        System.out.println("나누기: " + ((float)su1 / su2));
        System.out.println("나머기: " + (su1 % su2));

    }
}
