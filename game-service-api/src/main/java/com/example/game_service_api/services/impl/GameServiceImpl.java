package com.example.game_service_api.services.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(()-> new RuntimeException("Error game Not found"));
    }
}
