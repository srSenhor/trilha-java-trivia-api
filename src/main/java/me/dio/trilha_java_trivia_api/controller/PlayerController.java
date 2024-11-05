package me.dio.trilha_java_trivia_api.controller;

import me.dio.trilha_java_trivia_api.domain.model.Player;
import me.dio.trilha_java_trivia_api.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {
        var foundedPlayer = playerService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundedPlayer);
    }

    @GetMapping("/streak/{id}")
    public ResponseEntity<Integer> getStreak(@PathVariable Long id) {
        var foundedPlayer = playerService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundedPlayer.getStreak());
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player playerToBeCreated) {
        var createdPlayer = playerService.create(playerToBeCreated);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPlayer.getId())
                .toUri();
        return  ResponseEntity.status(HttpStatus.CREATED).location(location).body(createdPlayer);
    }

}
