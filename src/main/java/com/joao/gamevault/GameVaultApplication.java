package com.joao.gamevault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Game-Vault API", version = "1.0", description = "A Vault of Top Games API"))
public class GameVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameVaultApplication.class, args);
	}

}
