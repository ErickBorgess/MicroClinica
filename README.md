# MicroClínica 🏥

Este repositório contém a implementação de um sistema simples de gerenciamento para uma clínica médica, desenvolvido em Java.

O projeto foi dividido em **duas versões**, como forma de demonstrar evolução de código e aplicação de boas práticas de design:

**Versão Inicial → Implementação básica, focada apenas em entidades e serviços.**

**Versão Refatorada → Estrutura modularizada, aplicando padrões de projeto (Repository, Gateway) e padrões de resiliência (Circuit Breaker, Bulkhead).**

## 🚀 Funcionalidades

- Cadastro e gerenciamento de pacientes
- Cadastro e gerenciamento de profissionais de saúde
- Agendamento de consultas
- Serviços de manipulação dos dados (inserir, buscar, listar etc.)
- Aplicação de resiliência com `Circuit Breaker` e `Bulkhead` (na versão refatorada).
- `API Gateway` para centralizar as chamadas (na versão refatorada).

## 📂 Estrutura do Repositório

```bash
MicroClinica/
│── src/
│   ├── versao_inicial/
│   │   ├── MainInicial.java
│   │   ├── model/
│   │   │   ├── Paciente.java
│   │   │   ├── Profissional.java
│   │   │   └── Agendamento.java
│   │   └── service/
│   │       ├── PacienteService.java
│   │       ├── ProfissionalService.java
│   │       └── AgendamentoService.java
│   │
│   ├── versao_refatorada/
│       ├── MainRefatorado.java
│       ├── model/
│       │   ├── Paciente.java
│       │   ├── Profissional.java
│       │   └── Agendamento.java
│       ├── repository/
│       │   ├── PacienteRepository.java
│       │   ├── ProfissionalRepository.java
│       │   └── AgendamentoRepository.java
│       ├── service/
│       │   ├── PacienteService.java
│       │   ├── ProfissionalService.java
│       │   └── AgendamentoService.java
│       ├── gateway/
│       │   └── APIGateway.java
│       └── resilience/
│           ├── Acao.java
│           ├── Bulkhead.java
│           └── CircuitBreaker.java
│
├── README.md
└── .gitattributes
```

## 🛠️ Tecnologias Utilizadas

- Java 8+
- Programação Orientada a Objetos (POO)
- Collections (List, Map)
- Padrões de Projeto (Repository, Gateway, Service)
- Padrões de Resiliência (Circuit Breaker, Bulkhead)

## 📖 Diferença entre as versões
### 🔹 Versão Inicial
- Estrutura simples (model + service + main).
- Foco em mostrar entidades e serviços básicos.
- Menos modular.

### 🔹 Versão Refatorada
- Adição de repositórios para abstrair a camada de dados.
- `API Gateway` centralizando chamadas.
- Implementação de `Circuit Breaker` e `Bulkhead`.
- Código mais organizado e próximo de um sistema real.

## ▶️ Como Executar

1. Clone este repositório:
    ```bash
    git clone https://github.com/ErickBorgess/MicroClinica.git
    ```

2. Abra o projeto em sua IDE Java (Eclipse, IntelliJ, VS Code com extensão Java).

3. Navegue até a versão desejada:
    ```
    Para a versão inicial:
    Execute a classe MainInicial.java.

    Para a versão refatorada:
    Execute a classe MainRefatorado.java.
    ```
O programa rodará no console.

## 📚 Aprendizados e Objetivos

### Este projeto foi construído para fins acadêmicos, com os seguintes objetivos:

- Praticar conceitos de POO em Java.
- Demonstrar a evolução de um projeto entre uma versão inicial e uma refatorada.
- Aplicar padrões de design (Repository, Gateway, Service).
- Introduzir padrões de resiliência usados em sistemas distribuídos.

