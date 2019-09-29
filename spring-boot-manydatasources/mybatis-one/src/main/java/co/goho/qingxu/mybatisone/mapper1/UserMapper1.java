package co.goho.qingxu.mybatisone.mapper1;

import co.goho.qingxu.mybatisone.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper1 {

    List<User> selectAll();
}
