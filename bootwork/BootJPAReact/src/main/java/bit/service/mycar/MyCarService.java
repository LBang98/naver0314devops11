package bit.service.mycar;

import java.util.List;

import bit.data.mycar.MycarDto;
import org.springframework.stereotype.Service;

import bit.repository.mycar.MyCarDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyCarService {

    private MyCarDao myCarDao;

    public List<MycarDto> getAllDatas()
    {
        return myCarDao.getAllDatas();
    }

    public void insertMycar(MycarDto dto)
    {
        myCarDao.insertMycar(dto);
    }
    public void deleteMycar(long num){
        myCarDao.deleteMycar(num);
    }

    public MycarDto getData(Long num){

        return myCarDao.getData(num);
    }
    public void updateMycar(MycarDto dto){

        myCarDao.updateMycar(dto);
    }




}