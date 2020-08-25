package graduation.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/managerLogin")
    public String managerLogin(){
        return "managerLogin";
    }

    @RequestMapping("/userLogin")
    public String userLogin(){
        return "userPage";
    }

}
