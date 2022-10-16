package com.misiontic.USA.Ortesis.services;

import com.misiontic.USA.Ortesis.models.Ortopedic;
import com.misiontic.USA.Ortesis.repositories.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrtopedicService {
    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAllOrtopedic(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic insertOrtopedic(Ortopedic ortopedic){
        if (ortopedic.getId() == null) {
            return ortopedicRepository.save(ortopedic);
        }else
            return ortopedic;

    }

    public Ortopedic updateOrtopedic(Ortopedic ortopedic){
        if (ortopedic.getId() !=null){
            Optional<Ortopedic> temp = ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(!temp.isEmpty() ){
                if (ortopedic.getName() !=null)
                    temp.get().setName(ortopedic.getName());
                if (ortopedic.getBrand() !=null)
                    temp.get().setBrand(ortopedic.getBrand());
                if (ortopedic.getYear() !=null)
                    temp.get().setYear(ortopedic.getYear());
                if (ortopedic.getDescription() !=null)
                    temp.get().setDescription(ortopedic.getDescription());
                return ortopedicRepository.save(temp.get());
            }else
                return ortopedic;
        }else
            return ortopedic;
    }

    public boolean  deleteOrtopedic(int id){
        boolean aBoolean = getOrtopedic(id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
