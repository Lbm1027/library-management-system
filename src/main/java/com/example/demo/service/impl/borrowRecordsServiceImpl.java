package com.example.demo.service.impl;

import com.example.demo.domain.borrowRecords;
import com.example.demo.mapper.borrowRecordsMapper;
import com.example.demo.service.borrowRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class borrowRecordsServiceImpl implements borrowRecordsService {

    @Autowired
    private borrowRecordsMapper borrowRecordsMapper;

    @Override
    public borrowRecords getBorrowRecordById(int borrowID) {
        return borrowRecordsMapper.getBorrowRecordById(borrowID);
    }

    @Override
    public List<borrowRecords> getAllBorrowRecords() {
        return borrowRecordsMapper.getAllBorrowRecords();
    }

    @Override
    public List<borrowRecords> getBorrowRecordsByUserId(int userID) {
        return borrowRecordsMapper.getBorrowRecordsByUserId(userID);
    }

    @Override
    public List<borrowRecords> getBorrowRecordsByBookId(int bookID) {
        return borrowRecordsMapper.getBorrowRecordsByBookId(bookID);
    }

    @Override
    public void insertBorrowRecord(borrowRecords borrowRecord) {
        borrowRecordsMapper.insertBorrowRecord(borrowRecord);
    }

    @Override
    public void updateBorrowRecord(borrowRecords borrowRecord) {
        borrowRecordsMapper.updateBorrowRecord(borrowRecord);
    }

    @Override
    public void deleteBorrowRecord(int borrowID) {
        borrowRecordsMapper.deleteBorrowRecord(borrowID);
    }
}
