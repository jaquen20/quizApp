package com.example.quizApp.Repository;

import com.example.quizApp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Questions,Long> {
}
