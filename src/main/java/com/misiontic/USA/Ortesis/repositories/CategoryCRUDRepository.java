package com.misiontic.USA.Ortesis.repositories;

import com.misiontic.USA.Ortesis.models.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryCRUDRepository extends CrudRepository <Category, Integer> {
}
