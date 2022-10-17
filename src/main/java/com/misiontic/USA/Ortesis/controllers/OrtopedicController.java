package com.misiontic.USA.Ortesis.controllers;



import com.misiontic.USA.Ortesis.models.Ortopedic;
import com.misiontic.USA.Ortesis.services.OrtopedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ortopedic")
public class OrtopedicController {

    @Autowired
    private OrtopedicService ortopedicService;

    @GetMapping("/all")
    public List<Ortopedic> getAllOrtopedic(){
        return ortopedicService.getAllOrtopedic();
    }

    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id")int id){
        return ortopedicService.getOrtopedic(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic insertOrtopedic(@RequestBody Ortopedic ortopedic){
        return ortopedicService.insertOrtopedic(ortopedic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic updateOrtopedic(@RequestBody Ortopedic ortopedic){
        return ortopedicService.updateOrtopedic(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteClient (@PathVariable("id") int id){
        return ortopedicService.deleteOrtopedic(id);
    }
}
