package com.example.quizApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data @Entity
public class QuizSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalQuestion;
    private int correctAnswer;
    private int incorrectAnswer;

}
