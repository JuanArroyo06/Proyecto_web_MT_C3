package com.misiontic.USA.Ortesis.repositories;

import org.springframework.data.repository.CrudRepository;
import com.misiontic.USA.Ortesis.models.Reservation;

public interface ReservationCRUDRepository extends CrudRepository <Reservation, Integer> {
}
