package com.joao.gamevault.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
	
	@EmbeddedId
	private BelongingPK id = new BelongingPK();
	private Integer position;
	
	public Belonging() {}

	public Belonging(Game game, GameList gameList, Integer position) {
		id.setGame(game);
		id.setList(gameList);
		this.position = position;
	}
	
	
	
}
