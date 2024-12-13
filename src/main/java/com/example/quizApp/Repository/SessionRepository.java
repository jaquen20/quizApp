package com.example.quizApp.Repository;

import com.example.quizApp.Model.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<QuizSession,Long> {
}
