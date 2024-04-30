package day0321;

import java.util.Scanner;

public class Book199_9_if {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
            System.out.println("점수 입력");
            score = sc.nextInt();*/
        int ans, num = 0, score;
        int[] scores = new int[10];

        while (true){

            System.out.println("=".repeat(50));
            System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("=".repeat(50));

            System.out.print("선택 > ");
            ans = sc.nextInt();

            if(ans == 1){
                System.out.print("학생수 입력 > ");
                num = sc.nextInt();

            }
            if(ans == 2){
                for(int i=0; i<num; i++){
                    System.out.printf("score[%d] > ", i);
                    score = sc.nextInt();

                    scores[i] = score;

                }

            }
            if(ans == 3){
                for(int i=0; i<num; i++){
                    System.out.printf("score[%d] > %d\n", i, scores[i]);

                }
                System.out.println();
            }
            if(ans == 4){
                int avg = 0, sum = 0, su=0;

                for(int i=0; i<num; i++){
                    sum += scores[i];
                    su++;
                }

                avg = sum/su;
                for(int i=0; i<scores.length; i++){
                    for(int j=i+1; j<scores.length; j++){
                        if(scores[i] < scores[j]){
                            int temp = scores[j];
                            scores[j] = scores[i];
                            scores[i] = temp;

                        }
                    }
                }

                System.out.println("최고점수: " + scores[0] );
                System.out.println("평균점수: " + avg);


            }
            if(ans == 5){
                System.out.println("프로그램 종료");
                break;
            }




        }

    }
}
