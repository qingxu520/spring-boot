package co.goho.qingxu.springboot.dao;

import co.goho.qingxu.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
    User findByIdcard(String idcard);
    List<User> findByNameLike(String name);
}
