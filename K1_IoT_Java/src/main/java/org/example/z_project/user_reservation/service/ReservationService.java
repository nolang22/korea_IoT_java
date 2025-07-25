package org.example.z_project.user_reservation.service;

import org.example.z_project.user_reservation.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {

    void createReservation(String userId);
    List<ReservationResponseDto> getReservationByUserId(String userId);
    void cacelReservation(Long reservationId);
}
