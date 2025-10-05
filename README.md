# 🧱 Microsserviços com Spring Boot: Warehouse & Storefront

Projeto desenvolvido como parte do desafio da DIO para aplicar arquitetura de microsserviços com comunicação síncrona e assíncrona usando Spring Boot e RabbitMQ.

## 📦 Serviços

- **Warehouse**: Gerencia produtos e estoque.
- **Storefront**: Realiza compras e envia eventos via RabbitMQ.

## 🔗 Comunicação

- Síncrona via HTTP (Feign)
- Assíncrona via RabbitMQ

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- RabbitMQ
- Docker
- Swagger (OpenAPI)
- FeignClient
- Lombok
- Jakarta Validation

## 🐳 Como executar

1. Suba o RabbitMQ:
   ```bash
   docker-compose up -d
