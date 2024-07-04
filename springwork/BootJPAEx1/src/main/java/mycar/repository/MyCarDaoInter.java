package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mycar.data.MycarDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MyCarDaoInter extends JpaRepository<MycarDto, Long>{

    //사진을 선택 안했을경우는 사진과 구입날짜는 빼고 수정하는걸로 sql을 작성해보자
    //@Query : repository에 원하는 쿼리를 작성하게 해주는 어노테이션
    //value 속성 : 쿼리 작성부
    //nativeQuery : JPA에서 지정한 규칙을 모두 무시할 수 있는 속정
    @Query(value = """
            update mycar set carname=:carname, carprice=:carprice, carcolor=:carcolor where num=:num
            """, nativeQuery = true)
    @Modifying  //@Modifying은 insert, update, delete뿐만 아니라 DDL구문을 사용할 때도 표기를 해줘야 됩니다
    @Transactional  //@Transactional은 update, delete를 할 때 표기를 해줘야 정상 실행이 됩니다
    public void updateMycarNoPhoto(
            @Param("num") Long num, @Param("carname") String carname, @Param("carprice") int carprice, @Param("carcolor") String carcolor);

    //파라미터를 dto로 받은경우
    @Query(value = """
            update mycar set carname=:#{#dto.carname}, carprice=:#{#dto.carprice}, carcolor=:#{#dto.carcolor}  where num=:#{#dto.num}
            """, nativeQuery = true)
    @Modifying  //@Modifying은 insert, update, delete뿐만 아니라 DDL구문을 사용할 때도 표기를 해줘야 됩니다
    @Transactional  //@Transactional은 update, delete를 할 때 표기를 해줘야 정상 실행이 됩니다
    public void updateMycarNoPhoto(@Param("dto") MycarDto dto);

    //삭제
    @Query(value = "delete from mycar where num=:num",nativeQuery = true)
    @Modifying
    @Transactional
    public void delete(@Param("num") Long num);

}