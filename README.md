# API Back-End Java MySQL Farms Manager
<details>
   <summary>
      [English]
   </summary>

## Description

The API Back-End Java MySQL Farms Manager is a Java back-end application developed using the Spring ecosystem, specifically Spring Boot Web and Spring Data. This project is a RESTful API that manages farms and their crops, following a layered architecture to ensure separation of concerns and easy code maintenance.

## Features

- **Farm Creation**: Allows creating new farms with detailed information.
- **Farm Listing**: Returns a list of all registered farms.
- **Farm Query by ID**: Retrieves information of a specific farm based on its ID.
- **Crop Creation**: Allows adding new crops to an existing farm.
- **Crop Listing by Farm**: Returns a list of all crops associated with a specific farm based on its ID.
- **Fertilizer Creation**: Allows creating new fertilizers.
- **Fertilizer Listing**: Returns a list of all registered fertilizers.
- **Fertilizer Query by ID**: Retrieves information of a specific fertilizer based on its ID.

## Technologies Used

- Java
- Spring Boot Web
- Spring Data
- MySQL
- Docker
- Maven

## Getting Started

To start the project locally, follow these steps:

1. Make sure you have Docker installed on your machine.
2. Clone this repository to a folder of your choice:

   ```bash
   git clone git@github.com:devItaloAraujo/api-back-end-java-mysql-farms-manager.git

3. Navigate to the project directory:

   ```bash
   cd api-back-end-java-mysql-farms-manager
4. Execute the following command to start the Docker containers:

   ```bash
   docker-compose up -d
5. Wait until the containers are online.

The API will be available at the endpoint http://localhost:8080/farms

## Endpoints
### Farms (/farms)
**POST /farms:** Creates a new farm based on the data provided in the request body. Request body model:
   ```json
   {
     "name": "Farm1",
     "size": 6
   }
   ```

**GET /farms:** Returns a list of all registered farms.

**GET /farms/{id}:** Returns detailed information of a specific farm based on its ID.

**POST /farms/{id}/crops**: Creates a new crop on the specified farm based on its ID and the data provided in the request body. Request body model:
 ```json
   {
     "name": "VeggieCrop1",
     "plantedArea": 2
   }
   ```

### Crops (/crops)

**GET /crops:** Returns a list of all registered crops.

**GET /crops/{id}:**  Returns detailed information of a specific crop based on its ID.

### Fertilizers (/fertilizers)

**POST /fertilizers:** Creates a new fertilizer based on the data provided in the request body. Example:
```json
   {
     "name": "Compost",
     "brand": "Home made",
     "composition": "Organic Matter"
   }
   ```

**GET /fertilizers:** Returns a list of all registered fertilizers.

**GET /fertilizers/{id}:** Returns detailed information of a specific fertilizer based on its ID.

</details>
<details>
   <summary>
 [Português]
   </summary>
   
## Descrição

O API Back-End Java MySQL Farms Manager é uma aplicação back-end Java desenvolvida utilizando o ecossistema Spring, especificamente o Spring Boot Web e o Spring Data. Este projeto é uma API RESTful que gerencia fazendas e suas plantações, seguindo uma arquitetura em camadas para garantir a separação de escopos e a fácil manutenção do código.

## Funcionalidades

- **Criação de Fazendas**: Permite criar novas fazendas com informações detalhadas.
- **Listagem de Fazendas**: Retorna uma lista de todas as fazendas registradas.
- **Consulta de Fazenda por ID**: Permite recuperar informações de uma fazenda específica com base em seu ID.
- **Criação de Cultivos**: Permite adicionar novos cultivos a uma fazenda existente.
- **Listagem de Cultivos por Fazenda**: Retorna uma lista de todos os cultivos associados a uma fazenda específica com base em seu ID.
- **Criação de Fertilizantes**: Permite criar novos fertilizantes.
- **Listagem de Fertilizantes**: Retorna uma lista de todos os fertilizantes registrados.
- **Consulta de Fertilizante por ID**: Permite recuperar informações de um fertilizante específico com base em seu ID.

## Tecnologias Utilizadas

- Java
- Spring Boot Web
- Spring Data
- MySQL
- Docker
- Maven

## Rodando Localmente

Para iniciar o projeto localmente, siga estas etapas:

1. Certifique-se de ter o Docker instalado em sua máquina.
2. Clone este repositório em uma pasta de sua escolha:

   ```bash
   git clone git@github.com:devItaloAraujo/api-back-end-java-mysql-farms-manager.git
3. Navegue até o diretório do projeto:

   ```bash
   cd api-back-end-java-mysql-farms-manager
4. Execute o seguinte comando para iniciar os containers Docker:

   ```bash
   docker-compose up -d
5. Aguarde até que os containers estejam online.

A API estará disponível no endpoint http://localhost:8080/farms.

## Endpoints
### Fazendas (/farms)
**POST /farms:** Cria uma nova fazenda com base nos dados fornecidos no corpo da solicitação. Modelo do corpo da solicitação:
   ```json
   {
     "name": "Fazenda1",
     "size": 6
   }
   ```

**GET /farms:** Retorna uma lista de todas as fazendas registradas.

**GET /farms/{id}:** Retorna informações detalhadas de uma fazenda específica com base em seu ID.

**POST /farms/{id}/crops**: Cria uma nova plantação na fazenda especifica com base no seu id e nos dados fornecidos no corpo da solicitação. Modelo de corpo da solicitação:
 ```json
   {
     "name": "PlataçãoLegume1",
     "plantedArea": 2
   }
   ```

### Cultivos (/crops)

**GET /crops:** Retorna uma lista de todas as plantações registradas.

**GET /crops/{id}:** Retorna informações detalhadas de uma plantação específica com base em seu ID.

### Fertilizantes (/fertilizers)

**POST /fertilizers:** Cria um novo fertilizante com base nos dados fornecidos no corpo da solicitação. Exemplo:
 ```json
   {
     "name": "Compostagem",
     "brand": "Feita em casa",
     "composition": "Restos de alimentos"
   }
   ```

**GET /fertilizers:** Retorna uma lista de todos os fertilizantes registrados.

**GET /fertilizers/{id}:** Retorna informações detalhadas de um fertilizante específico com base em seu ID.

</details>
