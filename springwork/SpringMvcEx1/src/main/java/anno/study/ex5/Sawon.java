package anno.study.ex5;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Sawon {

    @Value("이병현")
    private String name;
    @Value("서울시 강동구")
    private String addr;
    @Value("50")
    private int age;
}
