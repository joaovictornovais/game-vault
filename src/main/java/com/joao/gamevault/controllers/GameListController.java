package com.joao.gamevault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.gamevault.dtos.GameListDto;
import com.joao.gamevault.dtos.GameMinDto;
import com.joao.gamevault.services.GameListService;
import com.joao.gamevault.services.GameService;

@RestController
@RequestMapping("/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDto> findAll() {
		return gameListService.findAll();
	}
	
	@GetMapping("/{listId}/games")
	public ResponseEntity<Object> findByList(@PathVariable Long listId) {
		if (gameService.findByList(listId).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game list not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(gameService.findByList(listId));
		}
	}

}
