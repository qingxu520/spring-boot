package co.goho.qingxu.mybatistag.mapper1;

import co.goho.qingxu.mybatistag.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper1 {

    List<User> selectAll();
}
