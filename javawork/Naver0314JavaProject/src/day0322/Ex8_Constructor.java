package day0322;
/*
*   생성자(constructor) 의 특징
*   1. 클래스명과 동일한 메서드명으로 만들어야한다
*   2. 리턴 타입이 없다
*   3. overloading 이 가능하다(여러개 생성 가능)
*   4. 생성할 때 단 한번 호출된다
*   5. 멤버변수의 초기화를 담당한다
* */
class kiwi{

    String name, addr;

    kiwi(){
        System.out.println("디폴트 생성자");
        name = "이미자";
        addr = "서울";
    }
    kiwi(String name){
        this.name = name;
        addr = "서울";
    }
    kiwi(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    public void show(){
        System.out.println(name + "님은 " + addr + "에 살고있어요");
    }
}
public class Ex8_Constructor {

    public static void main(String[] args) {
        kiwi k1 = new kiwi();
        k1.show();

        kiwi k2 = new kiwi("강호동");
        k2.show();

        kiwi k3 = new kiwi("영숙이","부산");
        k3.show();

    }
}
