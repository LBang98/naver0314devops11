package controller.board;

import data.dto.BoardAnswerDto;
import data.service.BoardAnswerService;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/board")
@RestController
public class BoardAnswerController {

    @Autowired
    private BoardAnswerService answerService;
    @Autowired
    private MemberService memberService;

    @PostMapping("/ainsert")
    public void insertAnswer(
            @RequestParam int num,
            @RequestParam String content,
            HttpSession session
    )
    {
        System.out.println("insert");
        //로그인한 아이디 얻기
        String myid=(String)session.getAttribute("loginid");
        //아이디에 해당하는 이름 얻기
        String writer=memberService.getDataById(myid).getName();
        //dto 에 필요한 데이터 넣기
        BoardAnswerDto dto=BoardAnswerDto.builder()
                .myid(myid)
                .writer(writer)
                .content(content)
                .num(num).build();

        answerService.insertAnswer(dto);
    }

    @GetMapping("/alist")
    public List<BoardAnswerDto> list(@RequestParam int num){

        return answerService.getAnswerData(num);
    }

    @GetMapping("/adelete")
    public void deleteAnswer(
            @RequestParam int aidx
    )
    {
        answerService.deleteAnswer(aidx);
    }

}
