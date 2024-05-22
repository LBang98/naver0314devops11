package member.service;

import lombok.RequiredArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
