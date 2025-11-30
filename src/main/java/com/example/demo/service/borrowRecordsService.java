package com.example.demo.service;

import com.example.demo.domain.borrowRecords;

import java.util.List;

public interface borrowRecordsService {
    borrowRecords getBorrowRecordById(int borrowID);

    List<borrowRecords> getAllBorrowRecords();

    List<borrowRecords> getBorrowRecordsByUserId(int userID);

    List<borrowRecords> getBorrowRecordsByBookId(int bookID);

    void insertBorrowRecord(borrowRecords borrowRecord);

    void updateBorrowRecord(borrowRecords borrowRecord);

    void deleteBorrowRecord(int borrowID);
}
