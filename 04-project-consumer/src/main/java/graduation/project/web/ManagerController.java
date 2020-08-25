package graduation.project.web;

import com.alibaba.dubbo.config.annotation.Reference;
import graduation.project.model.Location;
import graduation.project.model.Manager;
import graduation.project.service.ManagerService;
import graduation.project.service.PosionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagerController {
    @Reference(interfaceClass = ManagerService.class,version = "1.0.0",check = false)
    private ManagerService managerService;

    @RequestMapping("/manager/login/authentication")
    public String loginManager(Model model,String manager,String password){
        List<Manager> managerList = managerService.queryManager(manager,password);
        if (managerList.size() != 0){
            model.addAttribute("manager",managerList.get(0));
            return  "managePage";
        }
        model.addAttribute("message","用户或密码不存在，请重新登录");
        return "managerLogin";
    }
}
