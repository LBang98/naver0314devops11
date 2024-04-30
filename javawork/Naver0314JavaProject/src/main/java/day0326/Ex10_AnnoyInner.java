package day0326;

abstract class Hello{

    abstract public void study();
}
interface Happy{
    public void insert();
    public void delete();
}

class Kiwi{
    //익명 내부 클래스 형태
    Hello h = new Hello() {
        @Override
        public void study() {
            System.out.println("익명 내부 클래스에 대해서 공부중");
        }
    };

    Happy ha = new Happy() {
        @Override
        public void insert() {
            System.out.println("데이타를 추가합니다");
        }

        @Override
        public void delete() {
            System.out.println("데이타를 삭제합니다");
        }
    };
}


public class Ex10_AnnoyInner {
    public static void main(String[] args) {

        Kiwi k = new Kiwi();
        k.h.study();

        k.ha.insert();
        k.ha.delete();
    }
}
