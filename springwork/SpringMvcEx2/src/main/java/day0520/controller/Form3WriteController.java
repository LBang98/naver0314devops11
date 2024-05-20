package day0520.controller;

import day0520.dto.FoodDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form3WriteController {
    @PostMapping("/read3")
    public String read3(
            //폼 태그에서 같은 이름을 자동으로 읽어온다
            //Model에 foodDto라는 이름으로 저장이 된다
            //@ModelAttribute FoodDto dto

            //dto클래스명이 너무 긴 경우 간단하게 모델에 저장
            @ModelAttribute("fdto") FoodDto dto

            //@ModelAttribute 생략가능
            //FoodDto dto
            )
    {
        return "form3/result3";
    }

}
