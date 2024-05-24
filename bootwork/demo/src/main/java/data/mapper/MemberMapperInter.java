package data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapperInter {

   // @Select("SELECT COUNT(*) FROM memberdb")
    public int getTotalCount();


}
