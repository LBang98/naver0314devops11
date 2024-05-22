package member.controller;

import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberUpdateController {

    @NonNull
    private final MemberService memberService;

    @GetMapping("/updateform")
    public String updateform(@RequestParam("num") int num, Model model){
        MemberDto dto = memberService.getData(num);
        model.addAttribute("dto", dto);
        return "member/update-form";  // "member/update-form.jsp" 파일이 존재해야 합니다.
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute MemberDto dto,
            @RequestParam(value = "myfile", required = false) MultipartFile myfile,
            HttpServletRequest request
    ) {
        // 파일 업로드 처리
        if (myfile != null && !myfile.isEmpty()) {
            String realFolder = request.getSession().getServletContext().getRealPath("/resources");
            String originalFilename = myfile.getOriginalFilename();
            String fileExtension = "";
            int lastIndex = originalFilename.lastIndexOf(".");
            if (lastIndex != -1) {
                fileExtension = originalFilename.substring(lastIndex);
            }
            String fileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;

            try {
                myfile.transferTo(new File(realFolder + "/" + fileName));
                dto.setPhoto("/resources/" + fileName);  // URL 경로 설정
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 데이터 업데이트
        memberService.updateMember(dto);

        // 수정 후 디테일 페이지로 이동
        return "redirect:/member/detail?num=" + dto.getNum();
    }


    //{"status","success" or "fail}
    @ResponseBody
    @GetMapping("/delete1")
    public Map<String,String> delete(
            @RequestParam int num,
            @RequestParam String passwd)
    {
        Map<String,String> map = new HashMap<>();

        //비번이 맞을경우 데이타 삭제
        boolean b = memberService.isEqualPassCheck(num, passwd);
        if(b){
            memberService.deleteByNum(num);
        }
        map.put("status", b?"success":"fail");

        return map;
    }

}
