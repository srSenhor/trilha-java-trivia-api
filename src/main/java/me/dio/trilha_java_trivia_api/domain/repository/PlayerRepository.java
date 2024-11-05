package me.dio.trilha_java_trivia_api.domain.repository;

import me.dio.trilha_java_trivia_api.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> { }
