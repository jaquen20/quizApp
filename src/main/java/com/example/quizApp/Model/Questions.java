package com.example.quizApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity
public class Questions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Column(name = "option_a")
    private String optionA;
    @Column(name = "option_b")
    private String optionB;
    @Column(name = "option_c")
    private String optionC;
    @Column(name = "option_d")
    private String optionD;
    @Column(name = "correct_answer")
    private String correctAnswer;
}
