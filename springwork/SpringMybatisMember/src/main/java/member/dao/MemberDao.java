package member.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final SqlSession sqlSession;
    private final String namespace = "member.dao.MemberDao.";

    public int getTotalCount(){
        return sqlSession.selectOne(namespace+"memberTotalCount");
    }

    public List<MemberDto> getMemberList(){
        return sqlSession.selectList(namespace+"selectAll");
    }

    public int idCheck(String id){
        return sqlSession.selectOne(namespace+"idCheck",id);
    }

    public int insertMember(MemberDto memberDto){
        return sqlSession.insert(namespace+"insertMember",memberDto);
    }

    public int deleteByNum(int num){
        return sqlSession.delete(namespace+"deleteByNum",num);
    }

}
