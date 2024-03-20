package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStarsWith {
    public static void main(String[] args) {

        /*
        *   검색할 이름은? 강
        *   1번째 : 강호동
        *   5번째 : 강하나
        *   총 2명 검색
        *
        *   검색할 이름은? 박이
        *   "박이" 로 시작하는 멤버는 없습니다
        *
        *   검색할 이름은? Q
        *   ** 검색을 종료합니다 **
        * */
        String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
        Scanner sc = new Scanner(System.in);

        String name;
        boolean str;


        while (true){

            System.out.println("검색할 이름은?");
            name = sc.nextLine();
            int count=0;
            int searchNum = -1;

            //종료
            if(name.equalsIgnoreCase("q")) {
                System.out.println("** 검색을 종료합니다 **");
                break;
            }

            for(int i=0; i<members.length; i++){
                if (members[i].startsWith(name)){
                    count++;
                    searchNum = i;
                    System.out.println("\t" + (i+1) + "번째: " + members[i]);
                }
            }
            if(searchNum == -1){
                System.out.println("\t\"" + name + " 로 시작하는 멤버는 없습니다\n");
            }
            if(count != 0)
                System.out.println("\t총 " + count + "명 검색\n");

        }
    }
}
