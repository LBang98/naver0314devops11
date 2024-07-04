package mycar.controller;


import java.util.List;

import naver.cloud.NcpObjectStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import mycar.data.MycarDto;
import mycar.repository.MyCarDao;

@Controller
@RequiredArgsConstructor
public class MycarController {
    private final MyCarDao myCarDao;
    private final NcpObjectStorageService storageService;

    //bucket 명
    String bucketName="bitcamp-bh-98";
    //업로드할 폴더명
    String folderName="mycar";

    @GetMapping("/")
    public String home()
    {
        return "redirect:./mycar/list";
    }

    @GetMapping("/mycar/list")
    public String list(Model model)
    {
        List<MycarDto> list=myCarDao.getAllCars();
        model.addAttribute("list", list);
        model.addAttribute("count", list.size());
        return "mycar/mycarlist";
    }

    @GetMapping("/mycar/form")
    public String form()
    {
        return "mycar/mycarform";
    }

    @PostMapping("/mycar/insert")
    public String insertCar(@ModelAttribute MycarDto dto,
                            @RequestParam("carupload") MultipartFile carupload
    )
    {
        //사진을 업로드후 업로드된 파일명 반환
        String carphoto=storageService.uploadFile(bucketName, folderName, carupload);
        dto.setCarphoto(carphoto);
        //db insert
        myCarDao.insertCar(dto);

        return "redirect:./list";
    }

    @GetMapping("/mycar/detail")
    public String detail(@RequestParam("num") Long num,Model model)
    {
        MycarDto dto=myCarDao.getData(num);
        model.addAttribute("dto", dto);
        return "mycar/mycardetail";
    }

    //수정폼
    @GetMapping("/mycar/carupdate")
    public String updateform(@RequestParam("num") Long num, Model model){
        MycarDto dto = myCarDao.getData(num);
        model.addAttribute("dto", dto);

        return "mycar/mycarupdateform";
    }

    //수정
    @PostMapping("/mycar/update")
    public String update(@ModelAttribute("dto") MycarDto dto,@RequestParam("carupload") MultipartFile carupload){

        //수정 시 사진선택을 안한경우 carphoto에 "no"
        if(carupload.getOriginalFilename().equals(""))
            dto.setCarphoto("no");
        else {
            //사진수정을 하기 전 스토리지의 기존 사진을 지워보자
            String oldPhotoName = myCarDao.getData(dto.getNum()).getCarphoto(); //기존 파일명
            //스토리지에서 삭제
            storageService.deleteFile(bucketName, folderName, oldPhotoName);
            //다시 사진 업로드
            String photo = storageService.uploadFile(bucketName, folderName, carupload);
            dto.setCarphoto(photo); //dto에 업로드된 파일명 넣기
        }
        //수정 메서드 호출
        myCarDao.updateCar(dto);

        return "redirect:./detail?num=" + dto.getNum(); //상세보기로 이동
    }

    //삭제
    @GetMapping("/mycar/delete")
    public String delete(@RequestParam("num") Long num){
        myCarDao.delete(num);

        return "redirect:/";
    }


}