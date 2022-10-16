package com.misiontic.USA.Ortesis.controllers;

import com.misiontic.USA.Ortesis.models.Score;
import com.misiontic.USA.Ortesis.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List <Score> getScore(){
        return scoreService.getAllScore();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score insertScore(@RequestBody Score score){
        return scoreService.insertScore(score);
    }
}
