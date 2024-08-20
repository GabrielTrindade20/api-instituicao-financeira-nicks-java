# Banco Nicks / Nicks banck

## Visão Geral do Projeto
O projeto "DB Nicks" é uma API de gerenciamento de instituição financeira desenvolvida em Java, utilizando o framework Spring Boot. Essa API permite realizar diversas operações bancárias, como cadastro de clientes, abertura e gerenciamento de contas, realização de saques, depósitos, transferências, integração com o Pix e muito mais.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Boot**: Framework Java utilizado para construir a API de forma ágil e escalável.
- **SQL Server**: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados da aplicação.
- **REST API**: Arquitetura utilizada para expor os recursos da aplicação de forma padronizada e escalável.
- **Git**: Sistema de controle de versão utilizado para gerenciar o código-fonte do projeto.

## Arquitetura e Padrões de Projeto
A aplicação foi desenvolvida seguindo o padrão de arquitetura **Model-View-Controller (MVC)**. Esse padrão separa a lógica da aplicação em três camadas principais:

1. **Model**: Responsável pela representação dos dados e regras de negócio.
2. **Controller**: Responsável por receber as requisições, processar as informações e retornar as respostas adequadas.
3. **Service**: Camada intermediária entre o Controller e o Model, responsável por implementar a lógica de negócio.

Além disso, foram utilizados os seguintes padrões de projeto:

- **DAO (Data Access Object)**: Padrão utilizado para isolar a lógica de acesso a dados do restante da aplicação, facilitando a manutenção e a testabilidade.
- **Injeção de Dependência**: Padrão utilizado para promover o desacoplamento entre as diferentes camadas da aplicação, aumentando a flexibilidade e a testabilidade.

## Funcionalidades Implementadas
- Cadastro de clientes
- Abertura e gerenciamento de contas bancárias
- Realização de saques, depósitos e transferências
- Integração com o Pix para transferências
- Emissão e gerenciamento de cartões
- Geração de extratos bancários

## Estrutura do Projeto
O projeto segue uma estrutura de pastas baseada no padrão MVC:

```
com.projetoNicks.server/
├── controller/
├── model/
├── repository/
├── service/
└── ServerApplication.java
```

- `controller/`: Contém as classes responsáveis por receber as requisições HTTP e coordenar as respostas.
- `model/`: Contém as classes de modelo que representam as entidades do sistema.
- `repository/`: Contém as interfaces e implementações dos Data Access Objects (DAOs) para acesso aos dados.
- `service/`: Contém as classes de serviço responsáveis pela implementação da lógica de negócio.
- `ServerApplication.java`: Classe principal da aplicação, responsável por inicializar o Spring Boot.

## Próximos Passos
- Implementar testes unitários e de integração para garantir a qualidade do código.
- Adicionar mecanismos de autenticação e autorização, como tokens JWT, para proteger a API.
- Explorar técnicas de escalabilidade, como caching, filas de mensagens e design assíncrono, para lidar com altas cargas de trabalho.
- Documentar detalhadamente a API, incluindo a especificação das endpoints, modelos de dados e exemplos de uso.
- Integrar a aplicação com ferramentas de Continuous Integration/Continuous Deployment (CI/CD) para automatizar os processos de build, teste e implantação.

Sinta-se à vontade para me perguntar qualquer dúvida ou solicitar mais informações sobre o projeto.