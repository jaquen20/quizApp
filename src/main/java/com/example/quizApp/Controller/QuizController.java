package com.example.quizApp.Controller;

import com.example.quizApp.DAO.QuestionDao;
import com.example.quizApp.Exceptions.NoDataException;
import com.example.quizApp.Model.Questions;
import com.example.quizApp.Model.QuizSession;

import com.example.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/quiz-app")
@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(){
        try{
            return ResponseEntity.ok(quizService.startQuiz());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/questions")
    public ResponseEntity<?> getQuestion(){
        try{
            return ResponseEntity.ok(quizService.getQuestions());
        }catch (NoDataException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer){
        try {
            quizService.submitAnswer(sessionId,answer, questionId);
            return ResponseEntity.ok("Answer submitted");
        }catch (NoDataException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/result")
    public ResponseEntity<?> getResults(@RequestParam Long sessionId){
        try {
            return  ResponseEntity.ok(quizService.getUserResults(sessionId));
        }catch (NoDataException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
