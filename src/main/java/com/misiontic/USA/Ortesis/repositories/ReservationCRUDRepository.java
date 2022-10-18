package com.misiontic.USA.Ortesis.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.misiontic.USA.Ortesis.models.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationCRUDRepository extends CrudRepository <Reservation, Integer> {

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    public List<Reservation> findAllByStatus(String status);

//    public List<Reservation> findAllByStatusAndIdReservation(String status, int id);

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();
}


