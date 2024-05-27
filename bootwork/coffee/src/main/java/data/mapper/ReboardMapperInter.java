package data.mapper;

import data.dto.ReBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReboardMapperInter {

    public int getMaxNum();
    public void updateRestep(Map<String, Integer> map);
    public void insertBoard(ReBoardDto dto);
    public int getTotalCount();
    public List<ReBoardDto> getPagingList(Map<String, Integer> map);    //start, perpage
    public void updateReadCount(int num);
    public ReBoardDto getData(int num);



}
