package com.example.demo.service.impl;

import com.example.demo.domain.reservations;
import com.example.demo.mapper.reservationsMapper;
import com.example.demo.service.reservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationsServiceImpl implements reservationsService {

    @Autowired
    private reservationsMapper reservationsMapper;

    @Override
    public reservations getReservationById(int reservationID) {
        return reservationsMapper.getReservationById(reservationID);
    }

    @Override
    public List<reservations> getAllReservations() {
        return reservationsMapper.getAllReservations();
    }

    @Override
    public List<reservations> getReservationsByUserId(int userID) {
        return reservationsMapper.getReservationsByUserId(userID);
    }

    @Override
    public List<reservations> getReservationsByBookId(int bookID) {
        return reservationsMapper.getReservationsByBookId(bookID);
    }

    @Override
    public void insertReservation(reservations reservation) {
        reservationsMapper.insertReservation(reservation);
    }

    @Override
    public void updateReservation(reservations reservation) {
        reservationsMapper.updateReservation(reservation);
    }

    @Override
    public void deleteReservation(int reservationID) {
        reservationsMapper.deleteReservation(reservationID);
    }
}
