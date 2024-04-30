package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunje {
    public static void main(String[] args) {

        /*
        *   처음에 인원수(inwon) 를 입력받은 후 해당 인원수만큼
        *   name,koe,eng,tot,rank 변수를 배열 할당하고
        *   인원수만큼 이름, 국어점수, 영어점수를 입력하면
        *   총점과 등수를 계산해서 출력하는 프로그램을 작성하시오
        *
        *   출력은
        *   ======================================
        *   번호  이름  국어  영어  총점  등수
        *   ======================================
        *   1   강호동  90  100  190   1
        *   2   이영자  100  70  170   3
        *   3   유재석   90  90  180   2
        */

        Scanner sc = new Scanner(System.in);

        int inwon;
        System.out.println("인원수 입력");
        inwon = sc.nextInt();

        String[] name = new String[inwon];
        int[] koe = new int[inwon];
        int[] eng = new int [inwon];
        int [] tot = new int [inwon];
        int[] rank = new int[inwon];

        for(int i=0; i<inwon; i++){
            System.out.println("이름");
            sc.nextLine();
            name[i] = sc.nextLine();
            System.out.println("국어점수");
            koe[i] = sc.nextInt();
            System.out.println("영어점수");
            eng[i] = sc.nextInt();
        }

        System.out.println("=".repeat(30));
        System.out.println("번호\t이름\t\t국어\t영어\t총점\t등수");
        System.out.println("=".repeat(30));

        for(int i=0; i<inwon; i++){
            tot[i] = koe[i] + eng[i];
        }

        for(int i=0; i<inwon; i++){
            rank[i] = 1;

            for(int j=0; j<inwon; j++){
                if(tot[i] < tot[j])
                    rank[i]++;
            }


            System.out.println(i+1 + "\t" + name[i] + "\t" + koe[i] + "\t" + eng[i] + "\t" + tot[i] + "\t" + rank[i]);
        }
    }
}
