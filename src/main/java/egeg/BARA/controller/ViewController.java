package egeg.BARA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "join1";
    }

    @GetMapping("/signup2")
    public String signUp2() {
        return "join2";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/chatRoom")
    public String chatRoom() {
        return "chatRoom";
    }



    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }

//    @GetMapping("/chatBandjang")
//    public String chatBandjang(){
//        return "chatBandjang";
//    }
}
