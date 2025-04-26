# API de Gestão de Pacientes - Spring Boot

Este projeto consiste em uma API Java para gestão de pacientes utilizando Spring Boot. O sistema permite o cadastro, atualização, consulta e remoção de dados de pacientes.

# Pré-requisitos
- Java 11 ou superior
- Maven
- IDE (como IntelliJ IDEA ou Eclipse)

# Instalação

Clonando o Repositório
Primeiro, clone o repositório para a sua máquina local:
* git clone <URL-do-repositório>
* Limpar e criar a pasta */target*


# Construir o Projeto

Após clonar o repositório, navegue até o diretório do projeto e execute o seguinte comando para limpar e criar a pasta /target com os artefatos compilados:

* mvn clean package


# Configuração do Swagger

A API utiliza o Swagger para documentação interativa. Para configurar o Swagger, adicione as seguintes configurações no arquivo
* application.properties:
- https://springdoc.org/properties.html
- application.properties

Isso permite acessar a interface Swagger no endereço http://localhost:8080/ para interagir com a API de forma visual.

```
springdoc.swagger-ui.path=/
springdoc.swagger-ui.disable-swagger-default-url=true
```

# Navegação
Executar a API
Você pode rodar a aplicação usando o Maven. Para isso, execute o comando abaixo:
* mvn spring-boot:run
Isso iniciará o servidor na porta padrão 8080.

# Documentação da API (Swagger)
Após rodar a aplicação, a documentação interativa do Swagger estará disponível em:

- http://localhost:8080/swagger-ui.html


# Executar a API

Os seguintes endpoints estão disponíveis na API:

POST /pacientes: Criar um novo paciente

PUT /pacientes/{id}: Atualizar um paciente existente

DELETE /pacientes/{id}: Remover um paciente

GET /pacientes: Buscar todos os pacientes

GET /pacientes/{id}: Buscar paciente por ID


# Testes
Os testes automatizados para a API podem ser executados usando o seguinte comando Maven:
* mvn test
Isso executará todos os testes definidos no projeto.

# Estrutura do Projeto
* src/main/java/br/com/fiap/checkpoint1/: Contém o código-fonte da aplicação.

* controller/: Controladores da API.

* dto/: Objetos de Transferência de Dados (DTOs) para requisições e respostas.

* model/: Modelos de dados (entidades) que representam pacientes.

* service/: Lógica de negócio e operações relacionadas aos pacientes.


# Referencias
- https://springdoc.org/
- https://www.oracle.com/java/technologies/downloads/?er=221886#jdk24-windows
- https://www.java.com/pt-BR/

