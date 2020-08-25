package graduation.project.mapper;

import graduation.project.model.Location;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);

    List<Location> queryLoactionByName(@Param("name") String name);
}