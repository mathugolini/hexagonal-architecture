# Clean & Hexagonal Architecture — Sistema de Clientes

![Java](https://img.shields.io/badge/Java-25-orange?logo=coffeescript)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.8-brightgreen?logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-green?logo=mongodb)
![Kafka](https://img.shields.io/badge/Kafka-Event%20Streaming-black?logo=apachekafka)
![Docker](https://img.shields.io/badge/Docker-Container-blue?logo=docker)

---

## Visão Geral

Este projeto demonstra na prática a aplicação da **Arquitetura Hexagonal (Ports & Adapters)** e dos princípios da **Clean Architecture** em uma aplicação moderna com **Java 25** e **Spring Boot 3.4.8**.

O objetivo é mostrar como criar sistemas **desacoplados, testáveis e evolutivos**, utilizando **mensageria com Kafka**, **persistência em MongoDB** e **integração com APIs externas**, tudo isso orquestrado em **Docker**.

---

## Fluxo Geral

### API de Cliente
- Recebe os dados de um novo cliente.
- Busca automaticamente o **endereço** a partir do **CEP** consumindo a API.
- Persiste os dados no **MongoDB**.
- Publica o **CPF do cliente** em uma fila **Kafka** (`validar-cpf-topic`).

### API de Validação
- Consome mensagens da fila `validar-cpf-topic`.
- **Valida o CPF** e outros dados.
- Publica o resultado da validação em uma nova fila (`cpf-validado-topic`).

###  Retorno à API de Cliente
- A **API de Cliente** possui um *consumer* que escuta a fila `cpf-validado-topic`.
- Atualiza o registro do cliente no **MongoDB** com o status da validação.

---

## 🧠 Arquitetura Aplicada

O projeto segue o padrão **Hexagonal Architecture (Ports & Adapters)**, onde o **Domínio** é o núcleo isolado e as dependências externas (banco, mensageria, APIs) são tratadas como **adaptadores substituíveis**.

```bash
src/
 ├── main/
 │    ├── java/com/matheushugolini/cliente/
 │    │     ├── application/         # Casos de uso (lógica de aplicação)
 │    │     ├── domain/              # Entidades e regras de negócio puras
 │    │     ├── ports/               # Interfaces (input/output)
 │    │     ├── adapters/
 │    │     │     ├── in/            # Controllers REST, Kafka Consumers
 │    │     │     └── out/           # MongoDB, Kafka Producer, APIs externas
 │    │     └── config/              # Beans e injeção de dependências
 │    └── resources/
 │          ├── application.yml
 │          └── docker-compose.yml
 └── test/
       └── ...                       # Testes unitários e de integração


```
---
## Autor

**Matheus Hugolini**  
💻 Engenheiro de Software  
☁️ AWS Certified | Java | Spring | Arquiteturas Cloud