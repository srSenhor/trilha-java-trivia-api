package me.dio.trilha_java_trivia_api.controller;

import me.dio.trilha_java_trivia_api.domain.model.Guess;
import me.dio.trilha_java_trivia_api.domain.model.Question;
import me.dio.trilha_java_trivia_api.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        var foundedQuestion = questionService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundedQuestion);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question questionToBeCreated) {
        var createdQuestion = questionService.create(questionToBeCreated);
        var location = getLocation(createdQuestion.getId());
        return  ResponseEntity.status(HttpStatus.CREATED).location(location).body(createdQuestion);
    }

    @PostMapping("/guess")
    public ResponseEntity<Boolean> makeAGuess(@RequestBody Guess guess) {
        var guessResponse = questionService.attemptToAnswer(guess);
        var location = getLocation(guess.getId());
        return  ResponseEntity.status(HttpStatus.OK).location(location).body(guessResponse);
    }

    private URI getLocation(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
    }

}
