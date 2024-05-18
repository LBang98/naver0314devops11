package anno.study.ex4;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



//이번에는 tire 를 lombok 을 이용해서 주입해보자
@Component  //xml 에 car 로 등록
@RequiredArgsConstructor   //@NonNull 이 붙은 멤버변수마나 생성자로 주입된다
public class Car {

    @Value("아우디")
    private String carName;

    @NonNull
    private CanadaTire tire;

    public void carInfo(){
        System.out.println("자동차명: " +carName);
        System.out.println("타이어: " + tire.getTireName());
    }

}
