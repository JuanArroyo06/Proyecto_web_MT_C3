package com.misiontic.USA.Ortesis.services;

import com.misiontic.USA.Ortesis.models.Score;
import com.misiontic.USA.Ortesis.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScore(){
        return scoreRepository.getAll();
    }

    public Score insertScore(Score score){
        if (score.getId() == null) {
            return scoreRepository.save(score);
        }else
            return score;
    }

}
