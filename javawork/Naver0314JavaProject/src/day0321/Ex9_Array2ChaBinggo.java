package day0321;

import java.util.Scanner;

public class Ex9_Array2ChaBinggo {
    public static void main(String[] args) {
        /*
         *   1~3사이의 난수를 발생 후 가로,세로,대각선 방향으로
         *   같은 숫자가 나올경우 binggo 변수를 1 증가하여 빙고 갯수를 구하고
         *   같은 숫자가 없을경우 꽝!!! 이라고 출력하시오
         * */

        int[][] arr = new int[3][3];
        int binggo;
        Scanner sc = new Scanner(System.in);

        while (true) {

            binggo = 0;

            //2차원 배열에 1~3의 값을 임의로 발생
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = (int) (Math.random() * 3) + 1;
                }
            }
            //출력
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.printf("%4d", arr[i][j]);
                }
                System.out.println("\n");
            }
            //빙고갯수나 꽝 출력
            for (int i = 0; i < 3; i++) {

                //행방향
                if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                    binggo++;
                }
                //열방향
                if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                    binggo++;
                }

                // \ 대각선 방향
                if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
                    binggo++;
                }
                // / 대각선 방향
                if (arr[0][2] == arr[0][1] && arr[1][1] == arr[2][0]) {
                    binggo++;


                }


                if (binggo != 0)
                    System.out.println("빙고 갯수: " + binggo);
                else
                    System.out.println("꽝 !!!");

                System.out.println("=".repeat(15));

                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase("x")) {
                    System.out.println("** 빙고게임을 종료합니다 **");
                    break;
                }


            }


        }
    }
}
