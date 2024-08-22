# Projeto-PokeCenter-JavaPOO

Este projeto é uma aplicação Java que simula um Centro Pokémon, permitindo gerenciar Pokémon em uma equipe e em um PC. A aplicação inclui funcionalidades para cura de Pokémon e armazenamento de Pokémon em diferentes caixas.

## Estrutura do Projeto


- **src/com/mycompany/poke_center/**: Contém o código-fonte da aplicação.
  - **CentroPokemon.java**: Classe principal que gerencia os serviços.
  - **PcPokemon.java**: Classe que representa o armazenamento de Pokémon em caixas.
  - **PkmnCriar.java**: Classe que estende Pokémon.
  - **PkmnCuravel.java**: Interface para Pokémon curáveis.
  - **Pokemon.java**: Classe base para todos os Pokémon.
  - **Servico.java**: Classe abstrata para serviços.
  - **ServicoArmazenamento.java**: Serviço para armazenar e retirar Pokémon do PC.
  - **ServicoCura.java**: Serviço para curar Pokémon.
  - **Treinador.java**: Classe que representa um treinador e sua equipe de Pokémon.

## Conceitos de Programação Orientada a Objetos

### Classes e Objetos

- **Classes**: Representam os diferentes elementos da aplicação. Por exemplo, `Pokemon`, `CentroPokemon`, `Treinador`, `PcPokemon`, `Servico`, `ServicoCura`, e `ServicoArmazenamento`.
- **Objetos**: Instâncias das classes que interagem na aplicação. Por exemplo, um objeto da classe `Pokemon` representa um Pokémon específico.

### Encapsulamento

Os atributos das classes são encapsulados, ou seja, acessíveis apenas por meio de métodos públicos. Isso é feito para proteger os dados da aplicação e promover a segurança do código. Por exemplo, na classe `Pokemon`, os atributos `nome`, `specie`, `tipo`, `hp`, e `status` são acessíveis apenas através dos métodos getters e setters.

### Herança

Herança é utilizada para estabelecer relações de especialização entre as classes. Por exemplo, `PkmnCriar` herda de `Pokemon`, aproveitando os atributos e métodos definidos na classe base `Pokemon`.

### Polimorfismo

O polimorfismo permite que objetos de diferentes classes sejam tratados de maneira uniforme. Por exemplo, o método `curarPkmn` é implementado pela interface `PkmnCuravel` e é sobrescrito na classe `Pokemon`, permitindo que diferentes tipos de Pokémon sejam curados de maneira uniforme.

### Sobrecarga e Sobrescrita de Métodos

- **Sobrecarga**: Métodos com o mesmo nome mas com parâmetros diferentes. Exemplo: o método `addPokemon` na classe `Treinador` pode adicionar um Pokémon à equipe se a equipe tiver espaço.
- **Sobrescrita**: Métodos da classe base são redefinidos nas subclasses para modificar o comportamento. Exemplo: o método `executar` na classe `Servico` é sobrescrito nas classes `ServicoCura` e `ServicoArmazenamento` para implementar comportamentos específicos de cura e armazenamento.

### Classes Abstratas e Interfaces

- **Classes Abstratas**: Representam conceitos genéricos e não podem ser instanciadas diretamente. Exemplo: `Servico` é uma classe abstrata que define um contrato para serviços como `ServicoCura` e `ServicoArmazenamento`.
- **Interfaces**: Definem contratos que as classes devem implementar. Exemplo: `PkmnCuravel` define o método `curarPkmn`, que deve ser implementado por classes que representam Pokémon curáveis.

### Coleções

Utiliza coleções Java, como `ArrayList`, para armazenar e manipular grupos de objetos. Exemplo: `List<Pokemon>` é utilizado para gerenciar a equipe de um treinador e as caixas do PC.

### Manipulação de Arquivos

Não implementado.

### Exceções

Trata situações de erro ou condições inesperadas durante a execução do programa. Exemplo: `IllegalArgumentException` é lançado se um Pokémon com HP fora dos limites permitidos for definido ou se uma caixa inexistente for acessada.
