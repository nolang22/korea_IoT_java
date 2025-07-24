package org.example.user_reservation.service;

import org.example.user_reservation.dto.ReservationResponseDto;
import org.example.user_reservation.entity.Reservation;
import org.example.user_reservation.repository.ReservationRepository;

import java.util.List;

public interface ReservationService {

    void createReservation(String userId);
    List<ReservationResponseDto> getReservationByUserId(String userId);
    void cacelReservation(Long reservationId);
}
