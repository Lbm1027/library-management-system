package com.example.demo.mapper;

import com.example.demo.domain.users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface usersMapper {
    users getUserById(int userID);

    List<users> getAllUsers();

    List<users> getUsersByName(String name);

    void insertUser(users users);

    void updateUser(users users);

    void deleteUser(int userID);

    users getUserByName(String name);

    void updateMembershipType(int userID, String membershipType);
}
