package me.dio.trilha_java_trivia_api.service;

import me.dio.trilha_java_trivia_api.domain.model.Guess;
import me.dio.trilha_java_trivia_api.domain.model.Question;

public interface QuestionService {

    Question findById(Long id);
    Question create(Question questionToBeCreated);
    boolean attemptToAnswer(Guess guess);

}
