package controller.member;

import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberListController {

    @NonNull
    private MemberService memberService;

    @GetMapping("/member/list")
    public String memberList(Model model)
    {
        int totalCount = memberService.getTotalCount();
        model.addAttribute("totalCount", totalCount);

        return "member/memberlist";
    }

}