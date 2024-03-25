package day0325;

import java.util.Scanner;

class Parent{
    public String nation;

    public Parent(){
        this("대한민국");
        System.out.println("Parent() call");
    }

    public Parent(String nation) {
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}

class  Child extends Parent{
    public String name;

    public Child(){
        this("홍길동");
        System.out.println("child() call");
    }
    public Child(String name){
        this.name = name;
        System.out.println("Child(String name) call" + name);
    }

}
public class ExxE {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        Child child = new Child();


    }
}
