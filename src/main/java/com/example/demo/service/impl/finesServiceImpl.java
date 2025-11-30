package com.example.demo.service.impl;

import com.example.demo.domain.fines;
import com.example.demo.mapper.finesMapper;
import com.example.demo.service.finesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class finesServiceImpl implements finesService {
    @Autowired
    private finesMapper finesMapper;

    @Override
    public fines getFineById(int fineID) {
        return finesMapper.getFineById(fineID);
    }

    @Override
    public List<fines> getAllFines() {
        return finesMapper.getAllFines();
    }

    @Override
    public void insertFine(fines fine) {
        finesMapper.insertFine(fine);
    }

    @Override
    public void updateFine(fines fine) {
        finesMapper.updateFine(fine);
    }

    @Override
    public void deleteFine(int fineID) {
        finesMapper.deleteFine(fineID);
    }


    @Override
    public List<fines> getFinesByBorrowId(int borrowId) {
        return finesMapper.getFinesByBorrowId(borrowId);
    }


    @Override
    public void addFine(int borrowID, int amount) {
        fines fine = new fines();
        fine.setBorrowID(borrowID);
        fine.setAmount(amount);
        fine.setFineDate(Date.valueOf(LocalDate.now()));
        finesMapper.insertFine(fine);
    }
}
