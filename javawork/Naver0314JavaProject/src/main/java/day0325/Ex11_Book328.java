package day0325;

abstract class Animal2{

    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }
    public abstract void sound();
}
class Dog2 extends Animal2{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
class Cat2 extends Animal2{
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

public class Ex11_Book328 {
    public static void main(String[] args) {
        Dog2 d2 = new Dog2();
        d2.sound();

        Cat2 c2 = new Cat2();
        c2.sound();

        animal2Sound(new Dog2());
        animal2Sound(new Cat2());
    }

    public static void animal2Sound(Animal2 animal2){
        animal2.sound();
    }
}
