package member.controller;

import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberWriteController {

    private final MemberService memberService;

    @GetMapping("/form")
    public String memberFrom() {

        return "member/write-form";
    }

    @PostMapping("/insert")
    public String memberWrite(
            @ModelAttribute MemberDto dto,
            @RequestParam("photofile") MultipartFile photofile,
            HttpServletRequest request
    ) {
        String realFolder = request.getSession().getServletContext().getRealPath("/resources");

        String originalFilename = photofile.getOriginalFilename(); //같은 서버에 같은 파일명으로 업로드 하면 덮어쓰기 됨
        String fileExtension = "";
        int lastIndex = originalFilename.lastIndexOf(".");
        if (lastIndex != -1) {
            fileExtension = originalFilename.substring(lastIndex); // 파일 확장자 가져오기
        }
        String fileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;
        System.out.println(realFolder + "/" + fileName);


        try {
            photofile.transferTo(new File(realFolder + "/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        dto.setPhoto(fileName);

        memberService.insertMember(dto);

        return "redirect:/member/list";
    }

    @PostMapping("/insert1")
    public String insert(
            @ModelAttribute MemberDto dto,
            @RequestParam("myfile") MultipartFile myfile,
            HttpServletRequest request
    )
    {
        //업로드 경로 구하기
        String uploadPath=request.getSession().getServletContext().getRealPath("/resources");
        System.out.println(uploadPath);

        //업로드된 파일명을 dto 의 photo 에 저장
        String photo=myfile.getOriginalFilename();
        dto.setPhoto(photo);

        //업로드
        try {
            myfile.transferTo(new File(uploadPath+"/"+photo));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        //db 에 insert
        memberService.insertMember(dto);

        //목록페이지로 이동
        return "redirect:./list";
    }

}
