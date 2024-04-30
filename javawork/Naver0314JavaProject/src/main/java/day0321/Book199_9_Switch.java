package day0321;

import java.util.Scanner;

public class Book199_9_Switch {
    public static void main(String[] args) {

        int num=0, inwon=0, max=0, sum=0;
        double avg=0;
        int[] score = null;

        Scanner sc = new Scanner(System.in);

        Exit:
        while (true){
            System.out.println("=".repeat(50));
            System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("=".repeat(50));

            num = sc.nextInt();

            switch (num){
                case 1:
                    System.out.print("학생수 >>");
                    inwon = sc.nextInt();
                    //배열 메모리 할당
                    score = new int[inwon];
                    break;

                case 2:
                    for (int i=0; i<score.length; i++){
                        System.out.print("scores[" + i + "] >>");
                    }
                    break;

                case 3:
                    System.out.println("** 입력한 점수들 **");
                    for(int i=0; i< score.length; i++){
                        System.out.printf("%d 번째 점수: %d점\n", i+1, score[i]);
                    }
                    break;

                case 4:
                    //최대값 구하기
                    max = score[0]; //첫번째 점수를 일단 max로 지정
                    //1번 데이타부터 비교 후 max보다 클경우 max변경
                    for (int i=1; i< score.length; i++){
                        if(max < score[i])
                            max = score[i];
                    }
                    //총점, 평균 구하기
                    sum=0;
                    for (int s:score)
                        sum += s;
                    //평균
                    avg = sum/inwon;
                    System.out.println("** 성적 분석 결과 **");
                    System.out.println("최고점수: " + max);
                    System.out.println("합  계: " + sum);
                    System.out.printf("평  균: %5.2f\n",avg);
                    break;

                case 5:
                    System.out.println("프로그램 종료");
                    break Exit;

            }
            System.out.println();
        }
    }
}
