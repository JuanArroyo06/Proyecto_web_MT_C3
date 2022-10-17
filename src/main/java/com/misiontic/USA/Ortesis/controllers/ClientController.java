package com.misiontic.USA.Ortesis.controllers;


import com.misiontic.USA.Ortesis.models.Client;
import com.misiontic.USA.Ortesis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient") int idClient){
        return clientService.getClient(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteClient(@PathVariable("idClient") int idClient){
        return clientService.deleteClient(idClient);
    }








    }

