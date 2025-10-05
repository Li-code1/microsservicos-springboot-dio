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

2. Compile os microsserviços:

bash
mvn clean package
Execute os microsserviços:

bash
java -jar warehouse/target/*.jar
java -jar storefront/target/*.jar

3. Acesse o Swagger:

Warehouse: http://localhost:8081/swagger-ui.html

Storefront: http://localhost:8082/swagger-ui.html

📚 Aprendizados
Criação de microsserviços independentes

Comunicação entre serviços com HTTP e mensageria

Uso de RabbitMQ para eventos

Documentação e versionamento com GitHub

Projeto desenvolvido por [Liliane Lima]
