package com.example.demo.service;

import com.example.demo.domain.fines;

import java.util.List;

public interface finesService {
    fines getFineById(int fineID);
    List<fines> getAllFines();
    void insertFine(fines fine);
    void updateFine(fines fine);
    void deleteFine(int fineID);

    List<fines> getFinesByBorrowId(int borrowID);

    void addFine(int borrowID, int amount);
}
