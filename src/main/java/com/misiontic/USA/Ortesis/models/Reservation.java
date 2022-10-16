package com.misiontic.USA.Ortesis.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Reservations")
public class Reservation implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";


    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"reservation", "message"})
    private Ortopedic ortopedic;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservation", "message"})
    private Client client;

    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;

    //Getter and Setter


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}





