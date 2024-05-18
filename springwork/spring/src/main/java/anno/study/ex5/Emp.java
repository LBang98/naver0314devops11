package anno.study.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Emp {

    @Autowired
    private Sawon sawon;
    @Value("삼성")
    private String empName;
    @Value("2024-03-14")
    private String ipsaday;

    public void sawonInfo(){

        System.out.println("** 사원 정보 **");
        System.out.println("입사일 :"+ipsaday);
        System.out.println("회사명 : "+empName);
        System.out.println("사원명:"+sawon.getName());
        System.out.println("주소:"+sawon.getAddr());
        System.out.println("나이:"+sawon.getAge());

    }


}
