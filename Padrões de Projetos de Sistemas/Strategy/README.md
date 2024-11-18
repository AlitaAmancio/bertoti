# Padrão de Design Strategy - Projeto de Pagamento

## Sobre o Projeto

Este projeto demonstra a aplicação do padrão de design Strategy em Java para uma mini aplicação de sistema de pagamentos. O padrão Strategy é um padrão de design comportamental que permite que um algoritmo (ou estratégia) seja encapsulado em uma classe separada, permitindo que o algoritmo seja alterado independentemente do cliente que o utiliza.

### Objetivo do Padrão Strategy

O objetivo do padrão Strategy é separar o algoritmo (ou comportamento) da classe que o utiliza, permitindo que diferentes algoritmos sejam substituídos e utilizados de forma intercambiável. Isso promove a flexibilidade e a extensibilidade do código, facilitando a adição de novos comportamentos sem modificar o código existente. Um exemplo disso seria um aplicativo de transporte, onde a forma de calcular a tarifa pode variar dependendo da estratégia escolhida (por distância, por tempo ou uma combinação de ambos), e o sistema pode trocar entre essas estratégias sem alterar a lógica principal. Da mesma forma, em plataformas de e-commerce, diferentes algoritmos de recomendação podem ser utilizados de acordo com a estratégia desejada, como sugerir produtos com base em compras anteriores, nas tendências de pesquisa ou nos itens mais vendidos.
