package me.dio.trilha_java_trivia_api.domain.repository;

import me.dio.trilha_java_trivia_api.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> { }
