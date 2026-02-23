# Conceitos de Lógica e POO — Sistema de Gestão Espacial

Projeto de aprendizado desenvolvido em **Java** com foco na prática de conceitos fundamentais de **Programação Orientada a Objetos (POO)** e lógica de programação. O sistema simula o gerenciamento de uma estação espacial, contemplando astronautas, naves, missões e tarefas.

---

## Conceitos Praticados

- **Herança** — A classe `Astronauta` estende a classe abstrata `Pessoa`, herdando atributos como `nome` e `dataNascimento`
- **Classes Abstratas** — `Pessoa` serve como base para entidades que representam seres humanos
- **Encapsulamento** — Atributos privados com acesso via getters e setters
- **Enums** — Utilizados para representar estados e categorias (especialidades, status de saúde, tamanho de nave, etc.)
- **ArrayList e coleções** — Gerenciamento de listas de astronautas, tarefas, naves e missões
- **Exceções customizadas** — Validações de negócio lançadas como exceções específicas
- **Princípio da Responsabilidade Única (SRP)** — Separação clara entre entidades, serviços e queries
- **Lógica de negócio** — Regras como limite de tripulantes, validação de fadiga, compatibilidade de especialidade e nível de experiência

---

## Estrutura do Projeto

```
src/main/java/com/poo/
├── entities/         # Entidades do domínio
│   ├── Pessoa.java
│   ├── Astronauta.java
│   ├── Nave.java
│   ├── Estacao.java
│   ├── Missao.java
│   └── Tarefa.java
├── enums/            # Enumerações de estado e tipo
│   ├── Disponibilidade.java
│   ├── Especialidade.java
│   ├── NivelExperiencia.java
│   ├── StatusMissao.java
│   ├── StatusNave.java
│   ├── StatusSaude.java
│   └── TamanhoNave.java
├── exceptions/       # Exceções customizadas
│   ├── AstronautaStatus.java
│   ├── Existente.java
│   ├── IdadeMinima.java
│   ├── Indisponivel.java
│   ├── LimiteTripulantes.java
│   └── Prioridade.java
├── queries/          # Consultas de dados
│   ├── QueryAstronauta.java
│   ├── QueryEstacao.java
│   ├── QueryMissao.java
│   └── QueryNave.java
├── services/         # Regras de negócio e operações
│   ├── ServiceAlaMedica.java
│   ├── ServiceConvocacao.java
│   ├── ServiceRelatorio.java
│   └── ServiceTarefa.java
└── Main.java         # Ponto de entrada e demonstração
```

---

## Entidades

### `Pessoa` (abstrata)
Base para astronautas. Valida que a pessoa tem pelo menos 18 anos na criação — caso contrário, lança `IdadeMinima`.

### `Astronauta extends Pessoa`
Representa um astronauta com:
- **Especialidade**: `ENGENHEIRO`, `MEDICO`, `PILOTO`, `CIENTISTA`, `ZELADOR`
- **Nível de Experiência**: `JUNIOR`, `PLENO`, `SENIOR` (com hierarquia — um SENIOR pode executar tarefas de JUNIOR e PLENO)
- **Fadiga e StatusSaude**: calculados automaticamente. Fadiga ≤ 45 = `SAUDAVEL`, até 100 = `CANSADO`, acima = `FERIDO`
- **Lista de tarefas** atribuídas via `ArrayList`

### `Nave`
Possui uma estação de origem, tamanho (`P`, `M`, `G`) que define o limite de tripulantes (4, 6 ou 8), e uma missão ativa. Lança exceção ao tentar exceder o limite de tripulantes ou adicionar missão já ativa.

### `Estacao`
Gerencia listas de astronautas, naves e missões. Valida duplicatas por ID ou nome antes de adicionar.

### `Missao`
Contém tarefas e um nível de prioridade de 1 a 3. Inicia com status `PENDENTE` e vai para `ATIVA` ao ser atribuída a uma nave.

### `Tarefa`
Exige especialidade e nível mínimo de experiência. Ao atribuir um astronauta responsável, valida: fadiga (máximo 65), especialidade compatível e nível de experiência suficiente. O tempo da tarefa é gerado aleatoriamente (1–60 minutos).

---

## Serviços

| Serviço | Responsabilidade |
|---|---|
| `ServiceConvocacao` | Convoca um astronauta disponível para uma nave, alterando seu status para `CONVOCADO` |
| `ServiceTarefa` | Executa uma tarefa, calcula fadiga acumulada e define se foi concluída com sucesso |
| `ServiceAlaMedica` | Recupera um astronauta, zerando fadiga e restaurando saúde para `SAUDAVEL` |
| `ServiceRelatorio` | Calcula taxas de sucesso de tarefas por astronauta, missão, nave ou estação |

---

## Queries

Classes dedicadas exclusivamente a consultas, sem alterar estado:

- `QueryAstronauta` — lista ou busca tarefas de um astronauta
- `QueryEstacao` — lista ou busca astronautas, naves e missões de uma estação
- `QueryMissao` — lista ou busca tarefas de uma missão
- `QueryNave` — lista ou busca tripulantes de uma nave

---

## Exceções Customizadas

| Exceção | Quando é lançada |
|---|---|
| `IdadeMinima` | Astronauta com menos de 18 anos |
| `Existente` | Tentativa de cadastrar ID, nome ou tarefa duplicados |
| `Indisponivel` | Astronauta convocado ou nave/missão já ocupada |
| `LimiteTripulantes` | Nave com capacidade máxima atingida |
| `AstronautaStatus` | Fadiga alta, especialidade ou nível de experiência incompatíveis |
| `Prioridade` | Nível de prioridade da missão fora do intervalo 1–3 |

---

## Tecnologias

- **Java 17+**
- **Maven** (gerenciamento de dependências e build)
- **JUnit** (testes unitários)

---

## Como Executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/conceitos-de-logica-e-poo.git
cd conceitos-de-logica-e-poo

# Compilar e executar
mvn compile exec:java -Dexec.mainClass="com.poo.Main"

# Rodar os testes
mvn test
```

---

## Testes

O projeto possui testes unitários para todas as camadas: entidades, enums, exceções, queries e serviços. Os testes estão em `src/test/java/com/poo/`.

---

## Exemplo de Fluxo

```
Estação → Astronautas e Naves registrados
Missão criada e atribuída à Nave (status muda para ATIVA)
Astronautas convocados para a nave (ServiceConvocacao)
Tarefas atribuídas a astronautas compatíveis
Tarefas executadas → fadiga acumulada (ServiceTarefa)
Astronautas recuperados na ala médica (ServiceAlaMedica)
Relatórios de taxa de sucesso gerados (ServiceRelatorio)
```
