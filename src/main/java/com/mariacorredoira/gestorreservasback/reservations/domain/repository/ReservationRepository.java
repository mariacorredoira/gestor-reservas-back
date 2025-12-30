package com.mariacorredoira.gestorreservasback.reservations.domain.repository;

import com.mariacorredoira.gestorreservasback.reservations.domain.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository {
    Reservation save(Reservation reservation);

    Reservation findById(Long idUser, Long idActivity);

    List<Reservation> findAll(Long idUser);

    void delete(Long idUser, Long idActivity);

    boolean existsReservation(Long idUser, Long idActivity);
}
