package com.joao.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.gamevault.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
