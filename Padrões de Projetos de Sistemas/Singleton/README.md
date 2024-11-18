# Padrão de Design Singleton - Projeto de Conexão com Banco de Dados

## Sobre o Projeto

Este projeto demonstra a aplicação do padrão de design Singleton em Java para simular uma conexão com um banco de dados. O padrão Singleton é um padrão de design criacional que garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a essa instância.

### Objetivo do Padrão Singleton

O padrão Singleton tem como objetivo garantir que uma classe tenha apenas uma instância durante toda a execução do programa. Isso é especialmente útil quando se deseja controlar o acesso a recursos compartilhados, como conexões de banco de dados, configurações globais ou outras instâncias que precisam ser únicas. Ele promove o controle centralizado e evita a criação de múltiplas instâncias desnecessárias, economizando recursos e simplificando o gerenciamento.

Este padrão é amplamente utilizado em sistemas que requerem acesso exclusivo a um recurso, como em conexões de banco de dados, gerenciadores de configuração, loggers e cache de dados. No caso deste projeto, a classe `DatabaseConnection` usa o padrão Singleton para garantir que apenas uma instância de conexão com o banco de dados seja criada e gerenciada.
