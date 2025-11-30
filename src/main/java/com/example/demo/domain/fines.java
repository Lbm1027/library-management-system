package com.example.demo.domain;

import java.sql.Date;

public class fines {
    private int fineID;
    private int borrowID;
    private int amount;
    private Date fineDate;

    // Getters and Setters
    public int getFineID() {
        return fineID;
    }

    public void setFineID(int fineID) {
        this.fineID = fineID;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }
}
