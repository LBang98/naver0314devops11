package bit.repository.mycar;

import bit.data.mycar.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long>{

}