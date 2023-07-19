<h1 align="center">
    Game-Vault
</h1>

<p align="center">
    <img src="https://img.shields.io/badge/Tipo-Desafio-blue" />
</p>

<p>API que fornece uma lista de jogos que pode ser filtrada por categoria e com opção de mudar a posição de um jogo em uma lista.</p>

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Postgres](https://www.postgresql.org/)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)

## Práticas adotas

- Padrão REST para API Web
- Padrão de camadas
- Padrão DTO
- Consultas SQL no Spring Data JPA
- Projections
- Processo de deploy com CI/CD

## Como Executar

### Deploy

- A API possui um deploy na [railway](https://railway.app)
- Você pode acessó-lo pelo [link de deploy](https://game-vault-production.up.railway.app/)

O Swagger poderá ser visualizado em [swagger-ui/index.html](https://game-vault-production.up.railway.app/swagger-ui/index.html)

### Localmente

- Clonar repositório git
- Importar o projeto para sua IDE
- Executar o projeto;

A API poderá ser acessada em [localhost:8080](https://localhost:8080)

O Swagger poderá ser visualizado em [swagger-ui/index.html](https://localhost:8080/swagger-ui/index.html)

## API Endpoints

- GET /games

```
HTTP GET :8080/games
[
  {
    "id": 1,
    "title": "Game 1",
    "year": 2011,
    "imgUrl": "https://www.games.com/1/imgUrl",
    "shortDescription": "Game 1 short Description"
  },
   {
    "id": 2,
    "title": "Game 2",
    "year": 2012,
    "imgUrl": "https://www.games.com/2/imgUrl",
    "shortDescription": "Game 2 short Description"
  }
]
```

- GET /games/{id}

```
HTTP GET :8080/games/3
{
  "id": 3,
  "title": "Game 3",
  "year": 2013,
  "genre": "Role-playing (RPG), Shooter",
  "platforms": "XBox, Playstation, PC",
  "score": 4.8,
  "imgUrl": "https://www.games.com/3/imgUrl",
  "shortDescription": "Short description Game 3.",
  "longDescription": "Long description Game 3."
}
```

- POST /lists/{listId}/replacement

```
HTTP POST :8080/lists/1/replacement sourceIndex=1 destinationIndex=3

{}
```

- GET /lists

```
HTTP GET :8080/lists
[
  {
    "id": 1,
    "name": "Aventura e RPG"
  },
  {
    "id": 2,
    "name": "Jogos de plataforma"
  }
]
```

- GET /lists/{listId}/games

```
HTTP GET :8080/lists/1/games
[
  {
    "id": 1,
    "title": "Game 1",
    "year": 2012,
    "imgUrl": "https://www.games.com/1/imgUrl",
    "shortDescription": "Game 1 short description"
  },
  {
    "id": 2,
    "title": "Game 2",
    "year": 2019,
    "imgUrl": "https://www.games.com/2/imgUrl",
    "shortDescription": "Game 2 short description"
  },
  {
    "id": 3,
    "title": "Game 3",
    "year": 2018,
    "imgUrl": "https://www.games.com/3/imgUrl",
    "shortDescription": "Game 3 short description!"
  },
  {
    "id": 9,
    "title": "Game 9",
    "year": 2014,
    "imgUrl": "https://www.games.com/9/imgUrl",
    "shortDescription": "Game 9 short description"
  },
  {
    "id": 12,
    "title": "Game 12 ",
    "year": 2012,
    "imgUrl": "https://www.games.com/12/imgUrl",
    "shortDescription": "Game 12 short description"
  }
]
```
