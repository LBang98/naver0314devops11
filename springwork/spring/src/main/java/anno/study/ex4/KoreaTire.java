package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component
public class KoreaTire implements Tire{
    @Override
    public String getTireName(){

        return "한국타이어";
    }

}
