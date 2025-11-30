package com.example.demo.mapper;

import com.example.demo.domain.reservations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface reservationsMapper {
    reservations getReservationById(int reservationID);

    List<reservations> getAllReservations();

    List<reservations> getReservationsByUserId(int userID);

    List<reservations> getReservationsByBookId(int bookID);

    void insertReservation(reservations reservation);

    void updateReservation(reservations reservation);

    void deleteReservation(int reservationID);
}
