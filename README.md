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
![Inserir_cliente](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/inserir_cliente.png)
<br><br><br>
É possível observar o retorno do id quando o cliente é inserido.
![Inserir_cliente_id](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/inserir_cliente_id.png)
- 201 - Created
#### Read
![buscar_por_id_cliente](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/cliente_buscar_por_id.png)
<br><br><br>
Retorno da busca por id
```bash
{
	"id": 1,
	"nome": "Hudson Lucas Teles Vieira",
	"sexo": "MASCULINO",
	"idade": 22,
	"email": "Hudson@gmail.com",
	"cpfOuCnpj": "52840256010",
	"tipoCliente": "Pessoa Física",
	"enderecos": [
		{
			"id": 1,
			"logradouro": "Rua Flores",
			"numero": "300",
			"complemento": "apto 203",
			"bairro": "Jardim Helena",
			"cep": "3838092",
			"cidade": {
				"id": 1,
				"nome": "Uberlândia"
			}
		}
	],
	"telefones": [
		"192858-2673",
		"933350-8032"
	],
	"seguros": [
		{
			"id": 1,
			"tituloSeguro": "Seguro automovel 01",
			"valorSeguroAnual": "R$ 2.844,89",
			"propriedade": {
				"@type": "propriedadeAutomovel",
				"id": 1,
				"valorDaPropriedade": 35000.0,
				"quantidade": 1,
				"placa": "KAG2519",
				"modelo": "Civic 2017",
				"marca": "Honda",
				"anoFabricacao": "2018-03-12T03:00:00.000+00:00",
				"quantidadeDeProprietarios": 2,
				"quilometragem": 40000.0,
				"tempoHabilitacaoProprietario": "MEDIANO",
				"tempoHabilitacaoProprietarioDescricao": "Mediano",
				"valorDaPropriedadeFormatado": "R$ 35.000,00"
			},
			"coberturas": [
				"Incêndio",
				"Desastre natural",
				"Acidente"
			],
			"valorSeguroMensal": "R$ 237,07"
		},
		{
			"id": 5,
			"tituloSeguro": "Seguro de vida 01",
			"valorSeguroAnual": "R$ 10.000,00",
			"propriedade": {
				"@type": "propriedadeVida",
				"id": 5,
				"valorDaPropriedade": null,
				"quantidade": 1,
				"atestadoDeSaude": [
					{
						"id": 1,
						"dtCadastro": "2023-01-03T19:36:25.877+00:00",
						"nomeArquivo": "AtestadoSaudeHudson.pdf",
						"caminhoArquivo": "servidor/Documentos/AtestadoSaudeHudson.pdf"
					}
				],
				"praticaEsportesRadicaisDescricao": [
					"Não prática"
				],
				"valorAReceberDescricao": "Platinum 2",
				"valorAReceberDescricaoValor": "R$ 5.000.000,00",
				"consumoDrogasDescricao": [
					"Uso de bebidas alcóolicas",
					"Uso de medicamentos para tratamento"
				],
				"trabalhoDescricao": "Trabalho sem esforco físico",
				"valorDaPropriedadeFormatado": ""
			},
			"coberturas": [
				"Morte natural",
				"Suicídio",
				"Invalidez mental"
			],
			"valorSeguroMensal": "R$ 833,33"
		}
	],
	"sexoDescricacao": "Masculino"
}
```
- 200 - Ok

### Automóvel

#### Create
![inserir_automovel](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/inserir_automovel.png)
- 201 - Created
#### Read
![buscar_automovel](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/buscar_automovel.png)
- 200 - Ok

### Seguro

#### Create
![inserir_seguro](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/inserir_seguro.png)
- 201 - Created
#### Update -> Atualizar categórias
![atualizar_categorias](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/seguro_atualizar_categoria.png)
- 204 - No Content
#### Read
![buscar_seguro](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/buscar_seguro.png)
- 200 - Ok

### Read - Exceção
Exceção disparada ao tentar buscar um objeto que não existe pelo id
![buscar_seguro](https://github.com/oTalDoHud/Simulacao_Seguros/blob/main/Assets/cliente_excecao.png)



# Regras de negócio

Os bens podem ser assegurados seguindo o seu tipo, sendo eles vida, residência e automóvel. Posteriormente também é permitido registrar um seguro que, no que lhe concerne, porta coberturas que aumentam o custo desse seguro.

Algumas regras que a aplicação contem
- As categorias não podem se repetir
- Validação de placa (Mercosul)
- Validação de CPF

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
