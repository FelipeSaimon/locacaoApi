# Locação de veiculos - API
### É uma api para praticar os conhecimentos adquiridos no bootcamp decola tech da DIO

## Diagrama de classes
``` mermaid
classDiagram
    class Usuario {
        +int id
        +string nome
        +string cpf
        +string telefone
        +bool cadastrado
        +locarVeiculo(Veiculo veiculo)
        +devolverVeiculo()
    }

    class Veiculo {
        +int id
        +string modelo
        +string placa
        +bool disponivel
        +alugar()
        +devolver()
    }

    class Locacao {
        +int id
        +Usuario usuario
        +Veiculo veiculo
        +string dataInicio
        +string dataFim
        +bool ativo
        +finalizarLocacao()
    }

    Usuario "1" --> "0..1" Locacao : possui
    Veiculo "1" --> "0..1" Locacao : está em
```
