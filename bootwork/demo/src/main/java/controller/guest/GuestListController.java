package controller.guest;

import data.dto.GuestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GuestListController {

    @GetMapping("guest/list")
    public String list(){

        return "guest/guestlist";
    }

}
