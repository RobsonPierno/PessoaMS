# Projeto Java Spring Boot

Este projeto foi desenvolvido com o intuito de colocar em prática conhecimentos de desenvolvimento Java e Spring Boot, utilizando uma estrutura modular e integrando diversas tecnologias. Abaixo estão os detalhes das principais funcionalidades e tecnologias aplicadas.

## Estrutura Modular

O projeto é composto por dois módulos:

- **Módulo de Interface Feign**: Este módulo foi desenvolvido para ser importado em outros projetos, contendo as interfaces Feign necessárias para integração com o serviço.
  
- **Módulo de Serviço**: Este é o módulo principal da aplicação, onde estão implementados os recursos de serviço e processamento.

## Funcionalidades

- **Recepção de Mensagens com Kafka**: A aplicação é configurada para receber mensagens de um tópico Kafka, permitindo o processamento de dados enviados por outros sistemas de forma assíncrona.

- **Tratamento Global de Exceções (GlobalExceptionHandler)**: Foi implementado um GlobalExceptionHandler para gerenciar exceções de forma centralizada, assegurando respostas consistentes e tratadas para diferentes tipos de erros na API.

- **Conversão entre DTO e Entity com ModelMapper**: O projeto utiliza ModelMapper para converter objetos de transferência de dados (DTO) em entidades de banco de dados (Entity) e vice-versa, promovendo uma camada de abstração para facilitar o mapeamento de dados.

## Dockerização

O projeto está completamente dockerizado, facilitando a execução e a replicação do ambiente. O arquivo principal `docker-compose.yml`, que orquestra todos os serviços necessários para a solução, está incluído neste repositório.
