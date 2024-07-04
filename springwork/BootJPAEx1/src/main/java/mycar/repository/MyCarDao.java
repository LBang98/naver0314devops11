package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MycarDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao {

    private MyCarDaoInter daoInter;

    //db 저장
    public void insertCar(MycarDto dto){

        daoInter.save(dto); //id타입(num)이 포함되어있을경우 자동으로 update 실행, 없을경우 자동으로 insert 실행
    }

    //전체목록
    public List<MycarDto> getAllCars(){
        //return daoInter.findAll();   //추가된 순서로 반환
        //return daoInter.findAll(Sort.by(Sort.Direction.DESC, "carprice"));   //가격 내림차순
        //return daoInter.findAll(Sort.by(Sort.Direction.ASC, "carname"));   //자동차명 오름차순
        return daoInter.findAll(Sort.by(Sort.Direction.DESC, "num"));   //num의 내림차순
    }

    public MycarDto getData(Long num){
        return daoInter.getReferenceById(num);

    }
    public void updateCar(MycarDto dto){

        if(dto.getCarphoto().equals("no"))
            daoInter.updateMycarNoPhoto(dto.getNum(), dto.getCarname(), dto.getCarprice(), dto.getCarcolor());
        else
            daoInter.save(dto); //num이 포함되어있을경우 모든 컬럼 수정
    }

    public void delete(Long num){

        daoInter.deleteById(num);
    }


}
