package me.dio.trilha_java_trivia_api.service;

import me.dio.trilha_java_trivia_api.domain.model.Player;

public interface PlayerService {

    Player findById(Long id);
    Player create(Player playerToBeCreated);
    Integer getStreak(Long id);

}
