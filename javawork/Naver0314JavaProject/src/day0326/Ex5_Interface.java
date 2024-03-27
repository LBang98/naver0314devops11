package day0326;

interface Apple{
    public void one();
}
//인터페이스기리의 상속은 extends
interface Banana extends Apple{
    public void two();
}
class Orange implements Banana{
    @Override
    public void one() {
        System.out.println("하나");
    }

    @Override
    public void two() {
        System.out.println("둘");
    }

    public void three(){
        System.out.println("셋");
    }
}

public class Ex5_Interface {
    public static void main(String[] args) {

        Banana b = new Orange();
        b.one();
        b.two();
        ((Orange)b).three();

    }
}
