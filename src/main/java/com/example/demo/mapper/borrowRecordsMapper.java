package com.example.demo.mapper;

import com.example.demo.domain.borrowRecords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface borrowRecordsMapper {
    borrowRecords getBorrowRecordById(int borrowID);

    List<borrowRecords> getAllBorrowRecords();

    List<borrowRecords> getBorrowRecordsByUserId(int userID);

    List<borrowRecords> getBorrowRecordsByBookId(int bookID);

    void insertBorrowRecord(borrowRecords borrowRecord);

    void updateBorrowRecord(borrowRecords borrowRecord);

    void deleteBorrowRecord(int borrowID);
}
