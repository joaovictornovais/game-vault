package com.joao.gamevault.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joao.gamevault.dtos.GameListDto;
import com.joao.gamevault.entities.GameList;
import com.joao.gamevault.projections.GameMinProjection;
import com.joao.gamevault.repositories.GameListRepository;
import com.joao.gamevault.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDto(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
			List<GameMinProjection> list = gameRepository.searchByList(listId);
			
			GameMinProjection obj = list.remove(sourceIndex);
			list.add(destinationIndex, obj);
			
			int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
			int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
			
			for (int i = min; i<= max; i++) {
				gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			}
	}

}
