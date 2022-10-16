package com.misiontic.USA.Ortesis.services;


import com.misiontic.USA.Ortesis.models.Reservation;
import com.misiontic.USA.Ortesis.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);

    }

    public Reservation insertReservation(Reservation reservation){
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        }else
            return reservation;
    }

    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation() !=null){
            Optional<Reservation> temp = reservationRepository.getReservation(reservation.getIdReservation());
            if (!temp.isEmpty()){
                if (reservation.getStartDate() !=null)
                    temp.get().setStartDate(reservation.getStartDate());
                if (reservation.getDevolutionDate() !=null)
                    temp.get().setDevolutionDate(reservation.getDevolutionDate());
                return reservationRepository.save(temp.get());
            }else
                return reservation;
        }else
            return reservation;
    }


    public boolean deleteReservation(int idReservation){
        boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }



}
