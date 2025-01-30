# Gerenciamento de Vendas Modular - MERFLEX (Mercado flexivel)

Este é um projeto de **API** para o gerenciamento de vendas, que inclui funcionalidades para o cadastro de parceiros (vendedores), clientes, e apoio administrativo como controle de pagamentos dos clientes.

A API é construída utilizando **Spring Boot** e possui uma arquitetura modular, permitindo a expansão e a manutenção facilitada.

## Funcionalidades

- **Cadastro de Parceiros (Vendedores):** Gerenciamento de dados dos vendedores.
- **Cadastro de Clientes:** Gerenciamento de informações dos clientes.
- **Controle de Pagamentos:** Monitoramento e controle dos pagamentos realizados pelos clientes.
- **Mensageria (RabbitMQ):** Para processamento assíncrono e comunicação eficiente entre os módulos.
- **Documentação (Swagger):** Interface para visualização e testes da API.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para desenvolvimento da API.
- **RabbitMQ:** Sistema de mensageria para comunicação entre os componentes do sistema.
- **JPA (Java Persistence API):** Para interação com o banco de dados.
- **PostgreSQL:** Banco de dados principal para produção.
- **H2 Database:** Banco de dados em memória, utilizado para desenvolvimento e testes.
- **Swagger:** Para documentação da API e interação com os endpoints de forma simplificada.

## Endpoints

A API oferece endpoints para cadastro e gerenciamento de dados de parceiros, clientes e pagamentos. A documentação completa dos endpoints pode ser acessada através do Swagger.

- **URL Swagger:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) (após rodar a aplicação)

## Como Rodar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/glesiosantos/gerenciamento-de-vendas.git
```

### 2. Configurar o Banco de Dados

- O projeto utiliza **PostgreSQL** para produção. Para desenvolvimento, o **H2** é usado por padrão, mas você pode configurar o banco de dados conforme sua necessidade.
- Para usar o PostgreSQL, configure a aplicação no arquivo `application.properties` com as credenciais do seu banco.

### 3. Rodar a Aplicação

Para rodar o projeto, você pode utilizar o comando abaixo, que irá iniciar a aplicação Spring Boot localmente.

```bash
mvn spring-boot:run
```

Ou, se preferir, pode gerar um JAR executável com o comando:

```bash
mvn clean install
```

E então executar o JAR gerado:

```bash
java -jar target/gerenciamento-de-vendas.jar
```

### 4. Acessar a Documentação Swagger

Após rodar a aplicação, você pode acessar a documentação dos endpoints via Swagger na seguinte URL:

```
http://localhost:8080/swagger-ui.html
```

### 5. Mensageria com RabbitMQ

Certifique-se de ter o **RabbitMQ** configurado e em execução, caso esteja utilizando para comunicação entre os módulos. As configurações de fila podem ser ajustadas no arquivo `application.properties`.

## Colaboradores

Este projeto é mantido por:

- [Glesio Santos](https://github.com/glesiosantos)

## Contribuições

Contribuições são bem-vindas! Caso queira contribuir, siga os seguintes passos:

1. Faça um fork do repositório.
2. Crie uma branch para a sua modificação.
3. Realize a modificação e envie o pull request.

## Licença

Este projeto está licenciado sob a [MIT License]().

## TODO

- Melhorar o gerenciamento de erros.
- Implementar autenticação e autorização.
- Criar testes de integração.
- Implementar monitoramento e logs avançados.
