package com.joao.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.gamevault.dtos.GameMinDto;
import com.joao.gamevault.entities.Game;
import com.joao.gamevault.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameMinDto> findAll() {
		List<Game> resultGame = gameRepository.findAll();
		return resultGame.stream().map(x -> new GameMinDto(x)).toList();
	}
	
}
