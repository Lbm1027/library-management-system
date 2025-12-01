package com.example.demo.service.impl;

import com.example.demo.domain.users;
import com.example.demo.mapper.usersMapper;
import com.example.demo.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersMapper usersMapper;

    @Override
    public users getUserById(int userID) {
        return usersMapper.getUserById(userID);
    }

    @Override
    public users getUserByName(String name) {
        return usersMapper.getUserByName(name);
    }

    @Override
    public List<users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public List<users> getUsersByName(String name) {
        return usersMapper.getUsersByName(name);
    }

    @Override
    public int getNextUserId() {
        return usersMapper.getNextUserId();
    }

    @Override
    public void insertUser(users users) {
        usersMapper.insertUser(users);
    }

    @Override
    public void updateUser(users users) {
        usersMapper.updateUser(users);
    }

    @Override
    public void deleteUser(int userID) {
        usersMapper.deleteUser(userID);
    }

    @Override
    public void updateMembershipType(int userID, String membershipType) {
        usersMapper.updateMembershipType(userID, membershipType);
    }
}
