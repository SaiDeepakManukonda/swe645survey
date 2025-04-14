package com.Assignment3.swe645survey.repo;


import com.Assignment3.swe645survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyAppRepo extends JpaRepository<Survey,Integer> {

}
