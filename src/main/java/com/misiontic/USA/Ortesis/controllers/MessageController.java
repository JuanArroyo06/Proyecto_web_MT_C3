package com.misiontic.USA.Ortesis.controllers;



import com.misiontic.USA.Ortesis.models.Message;
import com.misiontic.USA.Ortesis.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message insertMessage(@RequestBody Message message){
        return messageService.insertMessage(message);
    }

    @GetMapping("/{idMessage}")
    public Optional<Message> getMessage(@PathVariable("idMessage") int idMessage){
        return messageService.getMessage(idMessage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateMessage(@RequestBody Message message){
        return messageService.updateMessage(message);
    }

    @DeleteMapping ("delete{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteMessage(@PathVariable("idMessage") int idMessage){
        return messageService.deleteMessage(idMessage);
    }
}
