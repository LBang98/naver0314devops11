package data.dto;

import lombok.*;

@NoArgsConstructor  //디폴트 생성자
@AllArgsConstructor //모든 멤버변수를 인자로 받는 생성자
//@Getter
//@Setter
//@ToString
@Data   //Setter + Getter + ToString
public class ShopDto {

    private String sang;
    private String photo;
    private int price;
    private int su;


}
