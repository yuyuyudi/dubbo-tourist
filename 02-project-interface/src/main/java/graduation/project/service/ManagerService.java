package graduation.project.service;

import graduation.project.model.Manager;

import java.util.List;

public interface ManagerService {

    Manager queryManagerById(Integer id);

    List<Manager> queryManager(String manager, String password);
}
