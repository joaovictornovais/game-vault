package com.joao.gamevault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.gamevault.dtos.GameMinDto;
import com.joao.gamevault.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDto> findAll() {
		return gameService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		if (gameService.findById(id) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(gameService.findById(id));
		}
	}
	
	
}
