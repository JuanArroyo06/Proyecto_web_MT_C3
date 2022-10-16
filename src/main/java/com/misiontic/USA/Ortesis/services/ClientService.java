package com.misiontic.USA.Ortesis.services;


import com.misiontic.USA.Ortesis.models.Client;
import com.misiontic.USA.Ortesis.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.getAll();

    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client insertClient(Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        }else
            return client;

    }


    public Client updateClient(Client client){
        if (client.getIdClient() !=null){
            Optional<Client> temp = clientRepository.getClient(client.getIdClient());
            if(!temp.isEmpty() ){
                if (client.getName() !=null)
                    temp.get().setName(client.getName());
                if (client.getEmail() != null)
                    temp.get().setEmail(client.getEmail());
                if (client.getAge() !=null)
                    temp.get().setAge(client.getAge());
                if (client.getPassword() !=null)
                    temp.get().setPassword(client.getPassword());
                return clientRepository.save(temp.get());
            } else
                return client;
        } else
            return client;
    }

    public boolean deleteClient(int idClient) {
        boolean aBoolean = getClient(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;

    }
}
