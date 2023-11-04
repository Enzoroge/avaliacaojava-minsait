# Avaliação Java Minsait

Este é um projeto desenvolvido como parte de uma avaliação Java. O projeto consiste em uma aplicação que lida com o gerenciamento de cadastro de pessoas e seus respectivos contatos
permitindo operações CRUD de contatos e pessoas.

## Tecnologias Utilizadas

- Java 17
- Spring Boot Versão 3.0.12
- Spring Data JPA
- Spring Web
- Springdoc OpenAPI
- MySQL
- Maven

## Pré-Requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven
- MySQL (Ou outro banco de dados compativel)
- Uma IDE Java(como IntelliJ IDEA ou Eclipse)


## Como Executar a Aplicação

1. Clone o repositório:

```bash
git clone https://github.com/Enzoroge/avaliacaojava-minsait

2. Configure o banco de dados MySQL:
   Certifique-se de que o MySQL esteja instalado e em execução em sua máquina.
   Acesse o arquivo src/main/resources/application.properties no seu projeto e verifique as configurações do banco de dados.
   Certifique-se de que as informações de URL, nome de usuário e senha estejam corretas. Por exemplo:
  -spring.datasource.url=jdbc:mysql://localhost:3306/cliente?useSSL=false&serverTimezone=UTC
  -spring.datasource.username=root
  -spring.datasource.password=123456

3. Abra o projeto em seu ambiente de desenvolvimento (IDE).

4. Execute o aplicativo Spring Boot. Você pode fazê-lo de várias maneiras, dependendo do seu ambiente de desenvolvimento:

No IntelliJ IDEA, você pode clicar com o botão direito do mouse no arquivo principal da aplicação e escolher a opção "Run".
No Eclipse, você pode clicar com o botão direito do mouse no projeto, selecionar "Run As" e escolher "Spring Boot App".

## Acesso à Documentação do OpenAPI
Após a inicialização do aplicativo, você pode acessar a documentação da API no seguinte URL:
http://localhost:8089/swagger-ui/index.html#/

