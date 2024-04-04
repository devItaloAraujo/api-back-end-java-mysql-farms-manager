# API Back-End Java MySQL Farms Manager

## Descrição

O API Back-End Java MySQL Farms Manager é uma aplicação back-end Java desenvolvida utilizando o ecossistema Spring, especificamente o Spring Boot Web e o Spring Data. Este projeto é uma API RESTful que gerencia fazendas e suas plantações, seguindo uma arquitetura em camadas para garantir a separação de escopos e a fácil manutenção do código.

## Funcionalidades

- **Criação de Fazendas**: Permite criar novas fazendas com informações detalhadas.
- **Listagem de Fazendas**: Retorna uma lista de todas as fazendas registradas.
- **Consulta de Fazenda por ID**: Permite recuperar informações de uma fazenda específica com base em seu ID.
- **Criação de Cultivos**: Permite adicionar novos cultivos a uma fazenda existente.
- **Listagem de Cultivos por Fazenda**: Retorna uma lista de todos os cultivos associados a uma fazenda específica com base em seu ID.

## Tecnologias Utilizadas

- Java
- Spring Boot Web
- Spring Data
- MySQL
- Docker
- Maven

## Começando

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
