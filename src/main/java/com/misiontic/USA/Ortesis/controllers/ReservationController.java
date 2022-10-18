package com.misiontic.USA.Ortesis.controllers;

import com.misiontic.USA.Ortesis.models.CompletedAndCancelled;
import com.misiontic.USA.Ortesis.models.Reservation;
import com.misiontic.USA.Ortesis.models.TotalAndClient;
import com.misiontic.USA.Ortesis.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List <Reservation> getReservation(){
        return reservationsService.getAllReservation();
    }

    @GetMapping("/{idReservation}")
    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation){
        return reservationsService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation insertReservation(@RequestBody Reservation reservation){
        return reservationsService.insertReservation(reservation);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationsService.updateReservation(reservation);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteReservation(@PathVariable("idReservation")int idReservation){
        return reservationsService.deleteReservation(idReservation);
    }

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2")String fecha2){
        return reservationsService.getReservationsBetweenDatesReport(fecha1, fecha2);
    }

    //Segundo Reporte
    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        return reservationsService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return reservationsService.getTopClientsReport();
    }



}
