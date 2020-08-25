package graduation.project.service;

import graduation.project.model.Location;

import java.util.List;

public interface PosionService {
    Integer insertLocation(String name, String coordinateX, String coordinateY);

    List<Location> queryAllPosition(String name);
}
