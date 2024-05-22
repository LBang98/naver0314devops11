package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class DetailController {

    @GetMapping("/detail")
    public String detail(@RequestParam int num, Model model) {


        return "member/member-detail";
    }
}
