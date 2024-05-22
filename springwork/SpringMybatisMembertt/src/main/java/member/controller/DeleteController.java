package member.controller;

import member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeleteController {

    @Autowired
    private member.service.MemberService memberService;

    @GetMapping("/detail")
    public String detail(){

//        String detail = memberService.detailMember();




        return "member/writeform";
    }
}

