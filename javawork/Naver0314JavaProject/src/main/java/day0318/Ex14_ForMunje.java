package day0318;

import java.util.Scanner;

public class Ex14_ForMunje {
    public static void main(String[] args) {

        /*
        *   5개의 점수(score)를 입력하면 갯수(count)와 합계(sum) 출력하기
        *   (단, 1~100 이 아닐 경우는 갯수에서 제외하고 합계에서도 제외하기-continue)
        *
        *   ex)
        *
        *   점수는?  80
        *   점수는?  120
        *   점수는?  70
        *   점수는?  60
        *   점수는?  100
        *
        *   입력한 점수 갯수: 4
        *   총 합계: 310
        * */

        Scanner sc = new Scanner(System.in);
        int score, count=0, sum=0;
        for(int i=1; i<=5; i++){
            System.out.println("점수는? ");
            score = sc.nextInt();

            if(score > 100 || score < 1){
                continue;
            }
            else {
                count++;
                sum+=score;
            }
        }
        System.out.printf("입력한 점수 갯수: %d\n", count);
        System.out.printf("총 합계: %d", sum);
    }
}
