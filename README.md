# Backend Simulação de Seguros
![GitHub](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)

# Sobre o projeto

Simulação de seguros é uma aplicação web backend, que faz o papel de um servidor com diversas regras de negócio, tipos de seguros e coberturas.

A aplicação consiste em diversas requisições web como inserção/atualização e consulta de clientes, propriedades, arquivos, categorias, endereços com cidades e estados e seguros. Algumas requisições serão demonstradas a seguir.


## Padrão MVC (Controllers, Services and repositories)

A aplicação está arquitetada no padrão MVC que consiste em dividir as responsabilidades entre Controller (Recebe requisições e envia respostas), Services (Realiza toda a lógica do negócio) e Repositories (Realiza todo tipo de acesso ao banco de dados).

## Requisições - CRUD
Todas as requisições foram feitas pelo [Insomnia](https://insomnia.rest/download "Site de download Insomnia"):
<br/>

### Cliente

#### Create
- 201 - Created
#### Read
- 200 - Ok

### Propriedade vida

#### Create
- 201 - Created
#### Read
- 200 - Ok

### Automóvel

#### Create
- 201 - Created
#### Read
- 200 - Ok

### Seguro

#### Create
- 201 - Created
#### Update
- 204 - No Content
#### Read
- 200 - Ok

### Read - Exceção


# Regras de negócio

Os bens podem ser assegurados seguindo o seu tipo, sendo eles vida, residência e automóvel. Posteriormente também é permitido registrar um seguro que, no que lhe concerne, porta coberturas que aumentam o custo desse seguro.

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Rest
- H2 database
- Maven
- Validation Api
- StringTemplate
- Lombok

# Autor

Hudson Lucas Teles Vieira

www.linkedin.com/in/otaldohud

hudson.lucas.vieira@gmail.com