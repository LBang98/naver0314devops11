package day0327;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex3_SetLotto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> setLotto = new TreeSet<>();

        while (true){
            System.out.println("로또를 구입할 금액을 입력하세요 (종료:0)");

            int money = sc.nextInt();

            if(money == 0){
                System.out.println("종료");
                break;
            }
            if(money < 1000){
                System.out.println("\t금액이 부족합니다");
                break;
            }
            for (int i = 0; i < money/1000; i++) {
                //6개의 중복되지 않은 로또 숫자 구하기(1~45)
                //기존 값 모두 삭제 후 다시 구하기
                setLotto.clear();

                while(true){

                    Random r = new Random();

                    int n = r.nextInt(1,45);
                    setLotto.add(n);

                    if(setLotto.size() == 6)
                        break;
                }
                //출력
                System.out.printf("%3d회 : ", i+1);
                for(int e:setLotto){
                    System.out.printf("%3d" , e);
                }
                System.out.println();
            }

        }

    }
}
