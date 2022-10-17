package com.misiontic.USA.Ortesis.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")
public class Message implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    //Llaves

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"message", "reservation"})
    private Ortopedic ortopedic;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"message", "reservations"})
    private Client client;

    //Getter and Setter

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}




