package day0315;

import java.util.Scanner;

public class Ex8_Munje {
    public static void main(String[] args) {
        /*
        * 이름(name), 핸드폰(hp), 태어난 연도(birthYear) 입력받은후
        * 이름,핸드폰,태어난 연도 ,나이(age, 2024-태어난 연도)
        * */

        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.println("핸드폰을 입력하세요: ");
        String hp = sc.nextLine();

        System.out.println("태어난 연도를 입력하세요: ");
        int birthYear = sc.nextInt();

        int a = 2024;
        int age = a - birthYear;

        System.out.println("이름: " + name);
        System.out.println("핸드폰: " + hp);
        System.out.println("나이: " + age + "살\t"+ "태어난 연도: " + birthYear + "년");

    }
}
