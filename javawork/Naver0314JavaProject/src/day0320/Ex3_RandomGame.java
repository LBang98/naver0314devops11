package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex3_RandomGame {
    public static void main(String[] args) {

        /*
        *   1. 1~100 사이의 난수를 발생한 후 숫자 알아맞추기
        *   2. 숫자 입력 시 앞의 횟수 출력
        *   3. 숫자(n)가 난수보다 크면 (n보다 작습니다)
        *   4. 드디어 숫자를 맞췄을 경우 (횟수와 정답을 출력 후)
        *   5. 계속 숫자 맞추기 게임을 하시겠습니까? (y/n)
        *   6. y를 누르면 다시 난수 발생 후 숫자 맞추기 시작
        *   7. y가 아니면 게임종료
        * */

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int su,count,rnd;
        Exit:
            while (true){
                //횟수 초기화
                count = 0;
                //난수 구하기
                rnd = r.nextInt(1,100); //1~100

                while (true){
                    System.out.printf(++count + "회 : ");
                    su = Integer.parseInt(sc.nextLine());

                    if(su > rnd){
                        System.out.println("\t" + su + "보다 작습니다");
                    }
                    else if (su < rnd) {
                        System.out.println("\t" + su + "보다 큽니다");
                    }
                    else {
                        System.out.printf("** 정답(%d)입니다 **",rnd);
                        System.out.println("\n\n계속하려면 y/n");
                        String ans = sc.nextLine();
                        if(ans.equalsIgnoreCase("y")){
                            System.out.println("** 새로운 게임을 시작합니다 **");
                            break;
                        }
                        else {
                            break Exit; //바깥쪽 while문을 빠져나간다
                        }
                    }

                }

            }
        System.out.println("** 게임을 종료합니다 **");

    }
}
