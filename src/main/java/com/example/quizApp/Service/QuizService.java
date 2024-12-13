package com.example.quizApp.Service;

import com.example.quizApp.DAO.QuestionDao;
import com.example.quizApp.Exceptions.NoDataException;
import com.example.quizApp.Model.Questions;
import com.example.quizApp.Model.QuizSession;

import com.example.quizApp.Repository.QuestionRepository;
import com.example.quizApp.Repository.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SessionRepository sessionRepository;


    public QuizSession startQuiz() {
        QuizSession quizSession = new QuizSession();
        quizSession.setTotalQuestion(0);
        quizSession.setCorrectAnswer(0);
        quizSession.setIncorrectAnswer(0);

        return sessionRepository.save(quizSession);
    }

    public QuestionDao getQuestions() {
        List<Questions> questionsList = questionRepository.findAll();
        if (questionsList.isEmpty()){
            throw new RuntimeException("no question found");
        }
        Questions questions=questionsList.get(new Random().nextInt(questionsList.size()));
        QuestionDao questionDao=new QuestionDao();
        questionDao.setQuestion(questions.getQuestion());
        questionDao.setId(questions.getId());
        questionDao.setOptionA(questions.getOptionA());
        questionDao.setOptionB(questions.getOptionB());
        questionDao.setOptionC(questions.getOptionC());
        questionDao.setOptionD(questions.getOptionD());
        return questionDao;
    }

    public void submitAnswer(Long sessionId, String answer, Long questionId) {
        QuizSession quizSession=sessionRepository.findById(sessionId).orElseThrow(()-> new NoDataException("session not found"));
        Questions question=questionRepository.findById(questionId).orElseThrow(()-> new NoDataException("question not found"));
        quizSession.setTotalQuestion(quizSession.getTotalQuestion()+1);

        if (answer.equalsIgnoreCase(question.getCorrectAnswer())){
            quizSession.setCorrectAnswer(quizSession.getCorrectAnswer() + 1);
        } else {
            quizSession.setIncorrectAnswer(quizSession.getIncorrectAnswer()+1);
        }
        sessionRepository.save(quizSession);
    }

    public QuizSession getUserResults(Long sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(()-> new NoDataException("session not found"));
    }
}