package com.joao.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joao.gamevault.dtos.GameDto;
import com.joao.gamevault.dtos.GameMinDto;
import com.joao.gamevault.entities.Game;
import com.joao.gamevault.projections.GameMinProjection;
import com.joao.gamevault.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll() {
		List<Game> resultGame = gameRepository.findAll();
		return resultGame.stream().map(x -> new GameMinDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		var optionalGameDto = gameRepository.findById(id);
		if (optionalGameDto.isEmpty()) {
			return null;
		} else {
			return new GameDto(optionalGameDto.get());
		}
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId) {
		List<GameMinProjection> resultGameMinProjection = gameRepository.searchByList(listId);
		return resultGameMinProjection.stream().map(x -> new GameMinDto(x)).toList();
	}
}
