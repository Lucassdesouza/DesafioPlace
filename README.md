## Desafio 3 - Place Tecnologia

Este projeto consiste em um webservice RESTful desenvolvido em Java com Spring Boot para gerenciar contratos e veículos. Ele permite criar, buscar, listar, atualizar e deletar contratos e veículos, além de gerar automaticamente um número de registro eletrônico para cada contrato.

## Pré-requisitos

*   Java JDK 17 ou superior
*   Maven
*   Postman ou Insomnia (para testar a API)
*   H2 Database (banco de dados em memória)

## Como Executar

1.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/desafio-place.git
    ```

2.  **Compilar e executar o projeto:**
    ```bash
    mvn spring-boot:run
    ```

3.  **Acessar a API:**
    *   A API estará disponível em `http://localhost:8080`.
    *   Utilize o Postman ou Insomnia para interagir com os endpoints da API.

## Endpoints da API

**Contratos:**

|Método|Endpoint|Descrição|
|:---|:---|:---|
|POST|/contratos|Cria um novo contrato.|
|GET|/contratos/{id}|Busca um contrato pelo ID.|
|GET|/contratos|Lista todos os contratos.|
|PUT|/contratos/{id}|Atualiza um contrato existente.|
|DELETE|/contratos/{id}|Deleta um contrato pelo ID.|

**Veículos:**

|Método|Endpoint|Descrição|
|:---|:---|:---|
|POST|/veiculos|Cria um novo veículo.|
|GET|/veiculos/{id}|Busca um veículo pelo ID.|
|GET|/veiculos|Lista todos os veículos.|
|PUT|/veiculos/{id}|Atualiza um veículo existente.|
|DELETE|/veiculos/{id}|Deleta um veículo pelo ID.|

## Exemplos de Requisição e Resposta (usando Postman)

**Criar um Contrato:**

```
POST /contratos
```

**Body (JSON):**

```json
{
  "nomeDevedor": "João Silva",
  "dataNascimentoDevedor": "1990-05-15",
  "veiculos": [
    {
      "numeroGravame": "123456",
      "numeroRenavam": "987654321",
      "placa": "ABC1234",
      "numeroChassi": "XYZ987654321"
    }
  ]
}
```

**Resposta (JSON):**

```json
{
  "id": 1,
  "nomeDevedor": "João Silva",
  "dataNascimentoDevedor": "1990-05-15",
  "numeroRegistroEletronico": "2024-123456", // O ano pode variar
  "veiculos": [
    {
      "id": 1,
      "numeroGravame": "123456",
      "numeroRenavam": "987654321",
      "placa": "ABC1234",
      "numeroChassi": "XYZ987654321",
      "contrato": {
        "id": 1
      }
    }
  ]
}
```

**Observações:**

*   O número de registro eletrônico (`numeroRegistroEletronico`) é gerado automaticamente no formato "anoCorrente-XXXXXX".
*   Os IDs dos contratos e veículos são gerados automaticamente pelo banco de dados.
*   Adapte os exemplos de acordo com os dados que você deseja testar.
