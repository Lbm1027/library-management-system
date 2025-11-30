package com.example.demo.service;

import com.example.demo.domain.reservations;

import java.util.List;

public interface reservationsService {
    reservations getReservationById(int reservationID);

    List<reservations> getAllReservations();

    List<reservations> getReservationsByUserId(int userID);

    List<reservations> getReservationsByBookId(int bookID);

    void insertReservation(reservations reservation);

    void updateReservation(reservations reservation);

    void deleteReservation(int reservationID);
}
