package member.controller;

import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberListController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    public String memberList(Model model) {
        model.addAttribute("totalCount", memberService.getTotalCount());
        model.addAttribute("memberList", memberService.getMemberList());

        return "member/member-list";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("myid") String myid) {
        int cnt = memberService.idCheck(myid);
        return cnt;
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, String> delete(@RequestBody Map<String, Object> requestBody) {
        int num = (int) requestBody.get("num");
        int isDeleted = memberService.deleteByNum(num);

        Map<String, String> response = new HashMap<>();
        if (isDeleted == 1) {
            response.put("status", "success");
        } else {
            response.put("status", "error");
            response.put("message", "회원 삭제에 실패했습니다.");
        }

        return response;
    }

}
