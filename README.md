# API de Trivia

Esse é um projeto desenvolvido para o desafio da [DIO](https://web.dio.me/) da trilha de Java com Spring.

## Do que se trata?

A API em si permite a criação de perguntas de múltipla escolha para uma trivia/quiz. Também os palpites de um jogador e contabiliza quantas perguntas este acertou em sequência.

## Diagrama de Classes

Segue o diagrama de classes descrevendo como é a relação das classes propostas:
```mermaid
classDiagram
    class Player {
        -String nickname
        -int streak
        -int maxStreak
    }

    class Guess {
        -long questionId
        -long playerId
        -String statementLabel
        -boolean correct
    }

    class Question {
        -String category
        -String difficult
        -String context
        -String answerLabel
        -Statement[] possibleAnswers
    }

    class Statement {
        -String label
        -String content
    }

    Player "1" *-- "1" Guess : do
    Guess "1" --* "1" Question : at
    Guess "1" o-- "1" Statement : has
    Question "1" *-- "0..*" Statement : contains
```

## Tecnologias usadas

- Java 21
- Framework Spring para criação do projeto
- OpenAPI/Swagger para documentação e teste dos *endpoints*



