package day0326;

interface StudyInter{
    public void javaStudy();
    public void springStudy();

}

interface PlayInter{
    public void run();
    public void game();
}

class MyStudy implements StudyInter{
    @Override
    public void javaStudy() {
        System.out.println("자바 스터티");
    }

    @Override
    public void springStudy() {
        System.out.println("스프링 스터디");
    }
}
class MyPlay implements PlayInter{
    @Override
    public void run() {
        System.out.println("달리기");
    }

    @Override
    public void game() {
        System.out.println("게임");
    }
}

public class Ex7_Interface {
    static public void study(StudyInter s){
        s.javaStudy();
        s.springStudy();
    }
    static public void play(PlayInter p){
        p.run();
        p.game();
    }

    public static void main(String[] args) {

        //위의 두 static 메서드를 호출해보세요
        study(new MyStudy());
        play(new MyPlay());


    }
}
