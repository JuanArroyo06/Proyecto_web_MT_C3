package com.misiontic.USA.Ortesis.services;



import com.misiontic.USA.Ortesis.models.Message;
import com.misiontic.USA.Ortesis.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message insertMessage(Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        }
        else
            return message;

    }

    public Message updateMessage(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> temp = messageRepository.getMessage(message.getIdMessage() );
            if(!temp.isEmpty() ){
                if (message.getMessageText() != null)
                temp.get().setMessageText( message.getMessageText() );
                return messageRepository.save(temp.get());
            }
            else
                return message;
        }
        else
            return message;
    }

    public boolean deleteMessage(int idMessage){
        Boolean aBoolean = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;


    }

}
