package co.goho.qingxu.mybatistag.mapper;

import co.goho.qingxu.mybatistag.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> selectAll();
}
