# 🧩 Sudoku em Java

## 📃 Descrição

Projeto de um jogo Sudoku desenvolvido em Java, com versão em terminal e interface gráfica.

Este projeto faz parte do desafio de projeto do bootcamp **Backend Java com AWS** da DIO e foi desenvolvido com o objetivo de praticar:

- Manipulação de arrays 2D
- Modelagem de classes
- Entrada de dados via argumentos (args)
- Aplicação de conceitos de arquitetura limpa

O jogo Sudoku consiste em preencher um tabuleiro 9x9 com números de 1 a 9, respeitando as seguintes regras:

- Não pode haver repetição de números nas **linhas**
- Não pode haver repetição nas **colunas**
- Não pode haver repetição nos **blocos 3x3**

---

## 🌿 Estrutura de Branches

O projeto está dividido em duas branches principais:

- `main` → versão com interação via terminal
- `ui` → versão com interface gráfica (Swing)

---

## 💻 Versão Terminal (Branch `main`)

### 📂 Estrutura do projeto
```bash
C:.
│   estrutura.txt
│   Main.java
│   
├───domain
│       Board.java
│       SmallSquare.java
│       StatusEnum.java
│       
└───util
        BoardTemplate.java
```

### ⚙️ Funcionalidades

1. Start Game
2. Put a new number
3. Remove a number
4. See current game
5. Verify game status
6. Clear game
7. Finish game
8. Exit game

### 🧐 Regras e funcionamento

- O tabuleiro possui **números fixos** e **não fixos**:
  - Fixos → não podem ser alterados (servem como dica)
  - Não fixos → podem ser editados pelo jogador

- O jogo precisa ser iniciado antes de qualquer ação, caso contrário, será exibida a mensagem:

```
  The game has not started yet
```

- Para inserir/remover valores:
  - O usuário informa o número da **linha e coluna**
  - Depois insere um número de **1 a 9**

- Status do jogo:
  - `Unstarted` → jogo não iniciado
  - `Incomplete` → ainda há células vazias
  - `Complete` → todas as células preenchidas (não garante que o jogo está correto)

- Para validar se o jogo está correto:
  - É necessário usar a opção **Finish Game**
- O jogo só finaliza se:
  - Não houver números repetidos nas linhas, colunas e nos blocos 3x3
  - Todas as células estiverem preenchidas

---

## 🖥️ Interface Gráfica (Branch `ui`)

### 📂 Estrutura do projeto

```bash
C:.
│   Main.java
│   UserInterfaceMain.java
│
├───domain
│       Board.java
│       SmallSquare.java
│       StatusEnum.java
│
├───service
│       BoardService.java
│
├───ui
│   └───costum
│       ├───button
│       │       CheckGameStatusButton.java
│       │       FinishGameButton.java
│       │       ResetButton.java
│       │
│       ├───frame
│       │       MainFrame.java
│       │
│       ├───input
│       │       NumberText.java
│       │       NumberTextField.java
│       │       NumberTextLimit.java
│       │
│       ├───panel
│       │       MainPanel.java
│       │       SudokuBlock.java
│       │       SudokuSection.java
│       │
│       └───screen
│               MainScreen.java
│
└───util
        BoardTemplate.java
```
### 🛠️ Tecnologias
- Java
- Swing (biblioteca padrão da JDK)

### ⚙️ Funcionalidades

1. Check game status
2. Reset game
3. Finish game

### 🧐 Regras e funcionamento

- O tabuleiro já inicia preenchido com valores fixos
- As regras de validação são as mesmas da versão terminal

### 🎮 Interação

- Clique nas células para inserir valores
- Use `TAB` para navegar entre células
- Use `DELETE` para apagar valores

### 📊 Status do jogo

- `Unstarted` → nenhum valor inserido
- `Incomplete` → ainda há espaços vazios
- `Complete` → todas as células preenchidas

### 🏁 Finalização

- Ao clicar em **Finish game**:
- O sistema valida linhas, colunas e blocos 3x3
- Se estiver correto:

```
  Great Job! You won the game
```

---

## 🛠️ Tecnologias Utilizadas no projeto

- Java
- Swing
- Git
- GitHub

---

## ▶️ Como Executar na sua Máquina

1. Instale o Java JDK (caso não tenha)
2. Clone o repositório:
3. Abra o projeto em uma IDE (IntelliJ IDEA ou VS Code)
4. Execute a classe `Main` na branch main e a classe `UserInterfaceMain` na branch ui

---

## 📸 Preview

<img width="580" height="589" alt="Screenshot 2026-04-06 234756" src="https://github.com/user-attachments/assets/dbd53908-b770-4ed7-a470-ac436dd4c6c0" />

---

## 👩‍💻 Autora

Scheila Paes

