package co.goho.qingxu.mybatisone.mapper;

import co.goho.qingxu.mybatisone.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();
}
