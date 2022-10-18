package com.misiontic.USA.Ortesis.repositories;


import com.misiontic.USA.Ortesis.models.Client;
import com.misiontic.USA.Ortesis.models.Reservation;
import com.misiontic.USA.Ortesis.models.TotalAndClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRepository.findAll();

    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationCRUDRepository.findById(idReservation);
    }

    public Reservation save(Reservation reservation) {
        return  reservationCRUDRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCRUDRepository.delete(reservation);
    }

    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCRUDRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCRUDRepository.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCRUDRepository.getTotalReservationsByClient();
        for(int i=0; i<reporte.size(); i++){
            respuesta.add(new TotalAndClient( (Long) reporte.get(i)[1], (Client) reporte.get(i)[0]) );
        }
        return respuesta;
    }
}

