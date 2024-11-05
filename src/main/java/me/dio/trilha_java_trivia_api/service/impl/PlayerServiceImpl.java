package me.dio.trilha_java_trivia_api.service.impl;

import me.dio.trilha_java_trivia_api.domain.model.Player;
import me.dio.trilha_java_trivia_api.domain.repository.PlayerRepository;
import me.dio.trilha_java_trivia_api.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Player create(Player playerToBeCreated) {
        if (playerRepository.existsByNickname(playerToBeCreated.getNickname())) {
            throw new IllegalArgumentException("Cannot create a new player cause this nickname already exists");
        }
        return playerRepository.save(playerToBeCreated);
    }

    @Override
    public Integer getStreak(Long id) {
        Player foundedPlayer = playerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return foundedPlayer.getStreak();
    }
}
