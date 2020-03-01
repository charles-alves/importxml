# Import XML

A aplicação foi implementada utilizando Java utilizando a plataforma **Spring Boot**.

Todos os endpoints estão acessíveis via Swagger a partir do link http://localhost:8080/swagger-ui.html

## Liveproject
O Projeto está acessível via [ImportXml](https://my-importxml.herokuapp.com/swagger-ui.html)

## Realizando upload
O upload do arquivo pode ser realizado a partir do endpoint **http://localhost:8080/documento**, realizando uma requisição POST para este endpoint com content-type **multipart/form-data**, o nome do campo é arquivo.

### Implementação
Para a implementação foram utilizados

- Maven
- Java 8
- Spring Boot
- Spring Data
- Swagger
