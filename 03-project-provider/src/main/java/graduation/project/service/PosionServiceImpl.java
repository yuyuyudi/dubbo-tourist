package graduation.project.service;

import com.alibaba.dubbo.config.annotation.Service;
import graduation.project.mapper.LocationMapper;
import graduation.project.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = PosionService.class,version = "1.0.0",timeout = 15000)
public class PosionServiceImpl implements PosionService {
    @Autowired
    private LocationMapper locationMapper;
    @Override
    public Integer insertLocation(String name, String coordinateX, String coordinateY) {
        Location location = new Location();
        location.setName(name);
        location.setCoordinateX(Double.valueOf(coordinateX));
        location.setCoordinateY(Double.valueOf(coordinateY));
        return locationMapper.insertSelective(location);
    }

    @Override
    public List<Location> queryAllPosition(String name) {
        return locationMapper.queryLoactionByName(name);
    }
}
