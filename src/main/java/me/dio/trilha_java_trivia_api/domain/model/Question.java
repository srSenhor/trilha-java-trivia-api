package me.dio.trilha_java_trivia_api.domain.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity(name = "tb_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String category;

    @Column(length = 12)
    private String difficult;

    @Column(length = 150)
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Column(length = 20, nullable = false)
    private String answerLabel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Statement> possibleAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public String getAnswerLabel() {
        return answerLabel;
    }

    public void setAnswerLabel(String answerLabel) {
        this.answerLabel = answerLabel;
    }

    public Map<String, Statement> getPossibleAnswer() {
        return possibleAnswer;
    }

    public void setPossibleAnswer(Map<String, Statement> possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }
}
