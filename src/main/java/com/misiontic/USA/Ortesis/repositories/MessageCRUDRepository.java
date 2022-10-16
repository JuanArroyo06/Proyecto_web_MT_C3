package com.misiontic.USA.Ortesis.repositories;

import com.misiontic.USA.Ortesis.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
}
