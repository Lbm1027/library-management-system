package com.example.demo.service;

import com.example.demo.domain.users;

import java.util.List;

public interface usersService {
    users getUserById(int userID);

    users getUserByName(String name);

    List<users> getAllUsers();

    List<users> getUsersByName(String name);

    void insertUser(users users);

    void updateUser(users users);

    void deleteUser(int userID);

    void updateMembershipType(int userID, String membershipType);
}
