package member.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class DetailController {

    @NonNull
    private MemberService memberService;

    @GetMapping("/detail")
    public String detail(@RequestParam int num, Model model) {

        MemberDto dto = memberService.getData(num);
        model.addAttribute("dto",dto);

        return "member/member-detail";
    }

    @ResponseBody
    @PostMapping("/member/upload")
    public Map<String, String> uploadPhoto(
            @RequestParam("upload")MultipartFile upload,
            @RequestParam int num,
            HttpServletRequest request
            )
    {
        //업로드할 경로 구하기
        String uploadPath = request.getSession().getServletContext().getRealPath("/resources");
        String photo = upload.getOriginalFilename();
        //업로드
        try {
            upload.transferTo(new File(uploadPath+"/"+ photo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //db에서 사진변경
        memberService.updatePhoto(num,photo);

        Map<String, String> map = new HashMap<>();

        map.put("photoname", upload.getOriginalFilename());

        return map;
    }
}
