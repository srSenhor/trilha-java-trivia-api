package me.dio.trilha_java_trivia_api.service.impl;

import me.dio.trilha_java_trivia_api.domain.model.Guess;
import me.dio.trilha_java_trivia_api.domain.model.Question;
import me.dio.trilha_java_trivia_api.domain.repository.QuestionRepository;
import me.dio.trilha_java_trivia_api.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Question create(Question questionToBeCreated) {
        Long id = questionToBeCreated.getId();
        if (id == null || questionToBeCreated.getContext().isEmpty() || questionRepository.existsById(id)) {
            throw new IllegalArgumentException("Cannot create a new question cause this id is invalid");
        }
        return questionRepository.save(questionToBeCreated);
    }

    @Override
    public boolean attemptToAnswer(Guess guess) {
        Question attemptedQuestion = findById(guess.getQuestionId());
        return attemptedQuestion.getAnswerLabel().equalsIgnoreCase(guess.getStatementLabel());
    }
}
