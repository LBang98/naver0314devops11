package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadOneController {

    @GetMapping("/uploadform1")
    public String upload1() {
        return "upload/uploadform1";
    }

    @PostMapping("/upload1")
    public String uploadPhoto1(
            @RequestParam String title,
            @RequestParam("upload") MultipartFile upload,
            HttpServletRequest request,
            Model model
    ) {
        // 톰캣서버에 배포된 프로젝트에서 이미지가 업로드될 경로 구하기
        String realFolder = request.getSession().getServletContext().getRealPath("/resources/upload");

        // 업로드할 파일명
        //String fileName = upload.getOriginalFilename();

        //동시에 여러명이 서버에 접근해서 업로드할 경우 같은 파일명인 경우 문제가 발생한다.
        // 그래서 랜덤 파일명으로 업로드를 해보자
        String fileName=UUID.randomUUID()+".jpg";


        System.out.println(realFolder + "/" + fileName); // 콘솔로 출력 후 탐색기를 열어서 이미지를 확인해주세요
        // 위의 경로에 해당 파일명으로 업로드 해보자
        try {
            upload.transferTo(new File(realFolder + "/" + fileName));
            // 업로드시 오류가 없다면 model에 저장
            model.addAttribute("title", title);
            model.addAttribute("photo", fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace(); // 오류 출력
        }

        System.out.println(realFolder);

        return "upload/resultphoto1";
    }
}
