package bit.mycar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.mycar.data.MycarDto;
import bit.mycar.repository.MyCarDao;
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



}