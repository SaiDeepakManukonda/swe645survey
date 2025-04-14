package com.Assignment3.swe645survey.controller;


import com.Assignment3.swe645survey.model.Survey;

import com.Assignment3.swe645survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class SurveyAppController {

    @Autowired
    private SurveyService surveyService;

    // CREATE
    @PostMapping
    public ResponseEntity<?> createSurvey(@RequestBody Survey survey) {
        try {
            Survey createdSurvey = surveyService.addSurvey(survey);
            return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating survey: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ ALL
    @GetMapping
    public ResponseEntity getAllSurveys() {
        return new ResponseEntity<>(surveyService.getAllSurveys(), HttpStatus.OK);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable int id) {
        Survey survey = surveyService.getSurveyById(id);
        return (survey != null)
                ? new ResponseEntity<>(survey, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSurvey(@PathVariable int id, @RequestBody Survey survey) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, survey);
            return (updatedSurvey != null)
                    ? new ResponseEntity<>("Survey updated successfully!!!", HttpStatus.OK)
                    : new ResponseEntity<>("Survey not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating survey: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable int id) {
        Survey survey = surveyService.getSurveyById(id);
        if (survey != null) {
            surveyService.deleteSurvey(id);
            return new ResponseEntity<>("Survey deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Survey not found.", HttpStatus.NOT_FOUND);
        }
    }
}
