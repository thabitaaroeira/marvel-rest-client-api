# marvel-rest-client-api
Rest client API for Marvel's API

O projeto marvel-rest-client-api consiste em uma API interna que orquestra a comunicação com a API da Marvel disponibilizada no site da mesma: https://developer.marvel.com/ 
Além disto, este projeto expõe operações de CRUD para duas entidades: Personagens e Criadores.

Este projeto foi implementado utilizando o Spring Boot Initializr.

Para execução deste, executar o comando Maven: "mvn clean install spring-boot:run", ou executar a classe main de nome MainConfig.java.

A API cliente da Marvel implementada expõe quatro (4) métodos (verbos HTTP) para manipular os objetos do tipo Character (Personagem) e Creator (Criador), em uma simulação de banco em memória.

Para acessar as funcionalidades é necessário ter um software para teste de endpoints REST, como o Curl, SoapUI, Postman, ARC (extensão Chrome), etc.

Após rodar o projeto, acessar a uri raiz http:localhost/8080/api . Existem dois possíveis resources: /characters e /creators . Cada um destes recebem os quatro verbos: GET que busca vários objetos (com ou sem parâmetros passados na url, por exemplo: http:localhost/8080/api/characters?name=Rogue&orderBy=name ou http:localhost/8080/api/creators?firstName=Stan&lastName=Lee ) e GET{id} que busca por id (do tipo inteiro); POST e um objeto JSON, para cadastro do objeto; DELETE {id} que recebe um id do tipo inteiro, e remove um objeto do banco em memória; PUT e um objeto JSON, que atualiza um registro no banco em memória.

IMPORTANTE! :: É necessário, antes de rodar o projeto, alterar o arquivo application.properties para preencher as chaves públicas e privadas do usuário interessado em executá-lo. Obviamente, as minhas chaves não serão disponibilizadas publicamente no GitHub.
