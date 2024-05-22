package member.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MemberService {
    private final MemberDao memberDao;

    public int getTotalCount(){
        return memberDao.getTotalCount();
    }

    public List<MemberDto> getMemberList(){
        return memberDao.getMemberList();
    }

    public int idCheck(String id){
        return memberDao.idCheck(id);
    }

    public void insertMember(MemberDto memberDto){
        memberDao.insertMember(memberDto);
    }

    public int deleteByNum(int num){
        return memberDao.deleteByNum(num);
    }

    public MemberDto getData(int num){
        return memberDao.getData(num);
    }
    public void updatePhoto(int num, String photo){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num",num);
        map.put("photo",photo);

        memberDao.updatePhoto(map);
    }
    public void updateMember(MemberDto dto) {
        memberDao.updateMember(dto);
    }


    public boolean isEqualPassCheck(int num, String passwd){

        Map<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("passwd", passwd);

        return memberDao.isEqualPassCheck(map);
    }


}
