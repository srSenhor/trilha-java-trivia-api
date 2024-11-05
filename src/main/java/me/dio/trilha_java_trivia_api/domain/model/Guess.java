package me.dio.trilha_java_trivia_api.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_guesses")
public class Guess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long playerId;

    @Column(nullable = false)
    private Long questionId;

    @Column(length = 20, nullable = false)
    private String statementLabel;

    private boolean correct;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getStatementLabel() {
        return statementLabel;
    }

    public void setStatementLabel(String statementLabel) {
        this.statementLabel = statementLabel;
    }
}
