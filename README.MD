<img src="https://raw.githubusercontent.com/mleitejunior/spring-customer-address-mysql/master/readme_resources/logo.png" title="Spring logo" alt="Spring Rest API">
<b>Customer/Addresss Rest API</b>

Esta API Rest tem o intuito de gerir Clientes e Endereços

## Techs
- Java 8
- Spring Boot 2.5.6
- Spring Security
- MySQL
- Hibernate
- Spring Data JPA
- JWT Authentication
- JUnit
- Mockito
- Maven

## Como rodar o projeto?

### Via Docker

Após baixar o projeto, em sua pasta raíz, execute o comando `docker-compose up` 

O comando irá automaticamente montar o banco de dados MySQL e rodar o projeto.


### Manualmente:

Você precisa de um banco MySQL em sua máquina com as configurações e nome do Schema de acordo com o encontrado no `application.properties` do projeto:

```
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabasetest?useSSL=false
spring.datasource.username=user
spring.datasource.password=password
```

Tendo o banco funcionando, baixe o projeto para seu computador através do ZIP ou do comando:

`git clone https://github.com/mleitejunior/lanches-rest-api-spring`


Rode a classe principal do projeto (`SpringCustomerAddressMysqlApplication`) em sua IDE.

## Manipulando os Customers / Addresses

Você poderá acessar os métodos através do Swagger-ui (WIP) ou via Postman:

![](https://github.com/mleitejunior/spring-customer-address-mysql/raw/main/readme_resources/postman_print.png)

Lembrando que as portas podem variar, a do docker está configurada assim:

```
SPRING_LOCAL_PORT=6868
SPRING_DOCKER_PORT=8080
```

LINK: [JSON da Collection do Postman já configurado!](https://raw.githubusercontent.com/mleitejunior/spring-customer-address-mysql/main/readme_resources/mydatabasetest.postman_collection.json)


### Autenticando:

Algumas requisições precisam de autenticação no sistema para funcionar, utilizando um Cliente API (como [Insomnia](https://insomnia.rest/download/) ou [Postman](https://www.postman.com/downloads/)), faça uma requisição POST em `http://localhost:9191/login` com as credenciais salvas em memória:

```
{
    "username" : "myusername",
    "password" : "password"
}
```

**Salve o bearer token** de resposta e o utilize para as outras requisições (o arquivo do Postman já citado possui tudo isto configurado).

## Database Schema

![](https://raw.githubusercontent.com/mleitejunior/spring-customer-address-mysql/master/readme_resources/mer.png)

LINK: [Código de criação do banco MYSQL!](https://github.com/mleitejunior/spring-customer-address-mysql/edit/main/readme_resources/database-script.sql)

*Entidades:*
- customer (clientes)
- address (endereços)

O atributo **customer_id_customer** em `address` existe para como relação "muitos para um", onde cada cliente pode possuir muitos endereços.

## Requisições e Regras de Negócios

Ainda implementada de forma simples, existem algumas regras de negócio implementadas no projeto:

**Address**

- Add Address: Necessita receber o ID de um Customer válido para ser criada.
- Find Addresses by Customer ID: Pega lista de endereços de um cliente, via o ID válido deste ultimo.

**Customer**

- Attributo `e-mail`: É único, sendo assim não é possível criar nem atualizar um cliente sem E-mail e o mesmo não pode existir préviamente no banco.

## Melhorias

**Testes:**
Os testes unitários até o momento não estão cobrindo todo o código, está sendo implementado especialmente para os métodos que possuam regras de negócio, necessitando de multiplas validações.

**Implementação do resto de um sistema:**
Por se tratar de um teste, não há muitas regras e um intuito específico para tal API existir. Seria interessante pensar em um caso real para "fechar o projeto".

**Frontend:**
Para consumir a API e visualizar o sistema.

**Autorização AWT:**
As credenciais estão salvas na memória, é interessante criar uma entidade `user` para registrar clientes (ou funcionários) para remover o username e password em código.

## Autor
* **Marcelo Leite Junior** - *Information Systems Final-years Student, code owner* - [mleitejunior's Github](https://github.com/mleitejunior) - `mleitejunior@gmail.com`
