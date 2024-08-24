#API de Aluno

Esta é uma API REST para gerenciamento de alunos, desenvolvida com Spring Boot e MySQL. O projeto segue padrões de design e arquiteturais para garantir uma estrutura sólida e manutenível.
Arquitetura e Design Patterns
Design Patterns

    Creational Design Patterns:
        Factory Method: Usado para criar instâncias de objetos de forma flexível.

    Structural Design Patterns:
        Proxy: Implementado para controlar o acesso aos objetos, normalmente utilizados para otimizar o desempenho ou adicionar funcionalidades adicionais.

    Outros Design Patterns:
        Dependency Injection: Utilizado para injetar dependências no contexto da aplicação, promovendo uma maior modularidade e testabilidade.
        Inversion of Control (IoC): Implementado através da Spring Framework para inverter o controle do fluxo de criação de objetos e gerenciamento de dependências.
        Entity: Representa uma entidade persistente no banco de dados.
        Data Transfer Object (DTO): Utilizado para transferir dados entre a API e o cliente.
        Repository: Interface responsável pelo acesso aos dados, utilizando Spring Data JPA.

#Arquitetura

    Model: Representa as entidades do domínio e suas relações com o banco de dados.
    Controller: Manipula as requisições HTTP, interage com o Model e retorna respostas apropriadas.

#Configuração

Para rodar o projeto localmente, você precisará do MySQL e do Spring Boot configurados adequadamente.
Configuração do Banco de Dados

    URL: jdbc:mysql://localhost:3308/banco
    Usuário: root
    Senha: (deixe em branco se não houver senha configurada)

#Configuração do Spring Boot

##Adicione as seguintes propriedades ao arquivo application.properties:
####Observação super importante caso você mude seu banco de dados ou mude tabela que voce vai interagir mude as configurações abaixo


spring.application.name=api-aluno
spring.datasource.url=jdbc:mysql://localhost:3308/banco #mude dde acordo com a sua necessidade
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

### OBS: caso você nao tenha nenhuma aplicação ou serviço rodando na porta 8080 voce não precisa adicionar essa linha abaixo .
server.port=8081


#Métodos HTTP Disponíveis

    GET /api/alunos: Retorna a lista de todos os alunos.
    GET /api/alunos/{matricula}: Retorna um aluno específico com base na matrícula.
    POST /api/alunos: Cria um novo aluno.
    PUT /api/alunos/{matricula}: Atualiza um aluno existente com base na matrícula.
    DELETE /api/alunos/{matricula}: Remove um aluno com base na matrícula.

#Executando Localmente

    Clone o repositório:

```

bash

git clone git@github.com:DevMiguelPinheiro/Projeto-Desenvolvimento-web.git
cd <DIRETORIO_DO_PROJETO>
```
##Configure o banco de dados: Certifique-se de que o MySQL está em execução e o banco de dados banco está criado na porta 3308.

##Compile e execute o projeto:

```
bash

./mvnw spring-boot:run
```
##Ou, se preferir usar o Maven diretamente:
```
bash

mvn spring-boot:run
```
#Acesse a API: A API estará disponível em http://localhost:8081.