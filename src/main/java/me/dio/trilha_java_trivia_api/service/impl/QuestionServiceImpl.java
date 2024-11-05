package me.dio.trilha_java_trivia_api.service.impl;

import me.dio.trilha_java_trivia_api.domain.model.Guess;
import me.dio.trilha_java_trivia_api.domain.model.Player;
import me.dio.trilha_java_trivia_api.domain.model.Question;
import me.dio.trilha_java_trivia_api.domain.repository.PlayerRepository;
import me.dio.trilha_java_trivia_api.domain.repository.QuestionRepository;
import me.dio.trilha_java_trivia_api.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final PlayerRepository playerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, PlayerRepository playerRepository) {
        this.questionRepository = questionRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Question create(Question questionToBeCreated) {
        String context = questionToBeCreated.getContext();
        if (context.isEmpty() || questionRepository.existsByContext(context)) {
            throw new IllegalArgumentException("Cannot create this question cause it context already exists");
        }
        return questionRepository.save(questionToBeCreated);
    }

    @Override
    public boolean attemptToAnswer(Guess guess) {
        Question attemptedQuestion = findById(guess.getQuestionId());
        boolean isCorrect = attemptedQuestion.getAnswerLabel().equalsIgnoreCase(guess.getStatementLabel());

        Player player = playerRepository.findById(guess.getPlayerId()).orElseThrow(NoSuchElementException::new);

        if (isCorrect) {
            player.incrementStreak();
        } else {
            player.setStreak(0);
        }

        playerRepository.save(player);

        return isCorrect;
    }
}
