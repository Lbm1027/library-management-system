package com.example.demo.mapper;

import com.example.demo.domain.fines;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface finesMapper {
    fines getFineById(int fineID);
    List<fines> getAllFines();
    void insertFine(fines fine);
    void updateFine(fines fine);
    void deleteFine(int fineID);

    List<fines> getFinesByBorrowId(int borrowId);
}
