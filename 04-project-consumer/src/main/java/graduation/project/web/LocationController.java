package graduation.project.web;

import com.alibaba.dubbo.config.annotation.Reference;
import graduation.project.model.Location;
import graduation.project.model.Manager;
import graduation.project.service.ManagerService;
import graduation.project.service.PosionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LocationController {
    @Reference(interfaceClass = PosionService.class,version = "1.0.0",check = false)
    private PosionService posionService;
    @RequestMapping("/add/location")
    public String addLocation(HttpServletRequest request){
        String name = request.getParameter("name");
        String coordinateX = request.getParameter("coordinateX");
        String coordinateY = request.getParameter("coordinateY");
        posionService.insertLocation(name,coordinateX,coordinateY);
        return "success";
    }

    @RequestMapping("/location/display")
    public @ResponseBody Object displayLocation(HttpServletRequest request){
        String name = request.getParameter("name");
        List<Location> locationList = posionService.queryAllPosition(name);
        if (locationList.size() != 0){
            return locationList;
        }
        return null;
    }
}
