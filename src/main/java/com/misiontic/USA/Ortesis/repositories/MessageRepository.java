package com.misiontic.USA.Ortesis.repositories;


import com.misiontic.USA.Ortesis.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCRUDRepository.findAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageCRUDRepository.findById(idMessage);
    }

    public Message save(Message message){
        return messageCRUDRepository.save(message);
    }

    public void delete(Message message){
        messageCRUDRepository.delete(message);
    }





}
