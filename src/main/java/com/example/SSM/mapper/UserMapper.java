package com.example.SSM.mapper;

import com.example.SSM.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {

//    int insertUser();
    void updateUser();
    void deleteUser();

    User getUserById();

    List<User> getAllUser();

    // 根据用户名查询用户信息
    User getUserByUsername(String username);

    User checkLogIn(String username, String password);

    User checkLogInMap(Map<String, Object> map);

    void insertUser(User user);

    User checkLogInByParam(@Param("username") String username, @Param("password") String password);
}
