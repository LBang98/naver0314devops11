package day0320;

import java.util.Scanner;

public class Ex11_ArrayRank {
    public static void main(String[] args) {

        /*
         *   등수를 구하는데 동점일 경우 동순위를 부여한다
         *   출력은     번호  점수  등수  순으로 출력한다
         * */
        Scanner sc = new Scanner(System.in);

        int[] score = {100, 90, 80, 90, 70};
        int[] rank = new int[5];

        for (int i = 0; i < score.length; i++) {
            rank[i] = 1;

            for (int j = 0; j < score.length; j++) {
                if (score[i] < score[j]) {
                    rank[i]++;
                }
            }
        }
        System.out.println("번호\t점수\t등수\t");
        System.out.println("=".repeat(20));
        for(int i=0; i<score.length; i++){
            System.out.println(i+1 + "\t" + score[i] + "\t" + rank[i]);
        }

        }
    }