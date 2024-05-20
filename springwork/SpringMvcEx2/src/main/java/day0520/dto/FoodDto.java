package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodDto {

    private String foodname;    //폼태그의 name과 같아야한다
    private String foodphoto;
    private int price;
    private int cnt;
}
