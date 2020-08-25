package graduation.project.service;

import com.alibaba.dubbo.config.annotation.Service;
import graduation.project.mapper.ManagerMapper;
import graduation.project.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = ManagerService.class,version = "1.0.0",timeout = 15000)
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper manangerMapper;
    @Override
    public Manager queryManagerById(Integer id) {
        return manangerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Manager> queryManager(String manager, String password) {
        return manangerMapper.selectByManageAndPassword(manager,password);
    }
}
