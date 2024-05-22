package member.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public MemberDto getData(int num) {
        return sqlSession.selectOne(namespace+"selectByNumData",num);
    }
    public void updatePhoto(Map<String, Object> map){
        sqlSession.update(namespace+"updatePhoto", map);
    }

    public MemberDto getMemberById(int id) {
        return sqlSession.selectOne(namespace + "selectMemberById", id);
    }

    public void updateMember(MemberDto dto) {
        sqlSession.update(namespace + "updateMember", dto);
    }

    public boolean isEqualPassCheck(Map<String, Object> map){

        int n = sqlSession.selectOne(namespace+"equalCheck",map);

        return n==1?true:false; //1이면 비번이 맞은경우니까 true 반환
    }


}
