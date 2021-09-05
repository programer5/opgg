package task.opgg.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
