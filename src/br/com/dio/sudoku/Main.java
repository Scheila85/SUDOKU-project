package br.com.dio.sudoku;

import br.com.dio.sudoku.domain.Board;
import br.com.dio.sudoku.domain.SmallSquare;
import br.com.dio.sudoku.util.BoardTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static Board board;

    public static void main(String[] args) {

        final Map<String, Integer> positionsFixedValue = new HashMap<>();

        for (String position : args) {
            String [] partes = position.split(",");
            String key = partes[0] +","+ partes[1];
            int value = Integer.parseInt(partes[2]);
            positionsFixedValue.put(key,value);
        }

        int optionGame = -2;

        while (true) {
            System.out.println("1. Start Game");
            System.out.println("2. Put a new number");
            System.out.println("3. Remove a number");
            System.out.println("4. See actual game");
            System.out.println("5. Verify game status");
            System.out.println("6. Clear game");
            System.out.println("7. Finish game");
            System.out.println("8. Exit game");

            optionGame = sc.nextInt();
            sc.nextLine();

            switch (optionGame) {
                case 1 -> startGame(positionsFixedValue);
                case 2 -> addNewNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Digite uma opção do menu.");

            }
        }
    }

    private static void startGame(Map<String,Integer> positionsFixedValue) {

        SmallSquare[][] boardMain = new SmallSquare[9][9];

        if (gameHasStarted()){
            System.out.println("The game has started!");
            return;
        }

        for (int i=0; i < boardMain.length; i++){
            for (int j=0; j < boardMain[i].length; j++) {
                String boardMainPositionLine = Integer.toString(i);
                String boarMainPositionColumn = Integer.toString(j);
                String boardMainPositionKey = boardMainPositionLine+","+boarMainPositionColumn;

                if (positionsFixedValue.containsKey(boardMainPositionKey)){
                    SmallSquare smallSquare = new SmallSquare(positionsFixedValue.get(boardMainPositionKey),true);
                    boardMain[i][j] = smallSquare;
                }else {
                    boardMain[i][j] = new SmallSquare(0, false);
                }
            }
        }
        board = new Board(boardMain);
        //System.out.println(Arrays.deepToString(boardMain));
        System.out.println("The game is ready to start!");
    }

    private static void addNewNumber() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        System.out.println("Type the number of line you wish to add the number");
        int line = currentNumberBetweenMinAndMax(1,9) -1;

        System.out.println("Type the column number you wish to add the number");
        int column = currentNumberBetweenMinAndMax(1,9) -1;

        System.out.println("Type the value you wish to add in the small square");
        int value = currentNumberBetweenMinAndMax(1,9);

        if (!board.addNewNumber(value,line,column)){
            System.out.print("It's not possible change the square number, because it's a fixed number position.");
        }
    }

    private static void removeNumber() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        System.out.println("Type the number of line you wish to remove a number");
        int line = currentNumberBetweenMinAndMax(1,9) -1;

        System.out.println("Type the column number you wish to remove a number");
        int column = currentNumberBetweenMinAndMax(1,9) -1;

        if (!board.removeANumber(line,column)){
            System.out.println("It's not possible change the square number, because it's a fixed number position.");
        }
    }

    private static void clearGame() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        board.clearNumbers();
        System.out.println("The board was restarted.");
    }

    private static void showGameStatus() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        System.out.printf("Current game status: %s\n", board.statusGame());

    }

    private static void showCurrentGame() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        SmallSquare[][] boardMain = board.getBoard();
        Object[] currentBoardTemplate = new Object[81];
        int currentBoardPos = 0;
        for (int i=0; i < boardMain.length; i++){
            for (int j=0; j < boardMain[i].length; j++){
                currentBoardTemplate[currentBoardPos ++] = " " + ((boardMain[i][j].getCurrentValue()==0) ? " " : boardMain[i][j].getCurrentValue());
            }
        }

        System.out.println("                                CURRENT GAME                          ");
        System.out.printf(BoardTemplate.BOARD_TEMPLATE+"\n", currentBoardTemplate);//Aceita apenas args (array comum);

    }

    private static void finishGame() {

        if (!gameHasStarted()){
            System.out.println("The game has not started yet.");
            return;
        }

        if (board.canFinishGame()){
            System.out.println("Great Job! You won the game!");
        } else {
            System.out.println("It's not possible finish the game.");
            System.out.println("The game contains errors or it is incomplete.");
        }
    }

    public static int currentNumberBetweenMinAndMax(int min, int max){

        int currentNumber = sc.nextInt();
        sc.nextLine();

        while (currentNumber < min | currentNumber > max){
            System.out.printf("Type a number between %d e %d \n", min,max);
            currentNumber = sc.nextInt();
        }
        return currentNumber;
    }

    public static boolean gameHasStarted (){

        return board != null;
    }

}











