package com.Assignment3.swe645survey.service;

import com.Assignment3.swe645survey.model.Survey;
import com.Assignment3.swe645survey.repo.SurveyAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyAppRepo repo;

    public List<Survey> getAllSurveys(){
        return repo.findAll();
    }

    public Survey getSurveyById(int id) {
        return repo.findById(id).orElse(null);
    }


    public Survey addSurvey(Survey survey) {
        return repo.save(survey);
    }

    public Survey updateSurvey(int id, Survey survey) {
        return repo.save(survey);
    }

    public void deleteSurvey(int id) {
        repo.deleteById(id);
}
}
