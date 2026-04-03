package br.com.dio.sudoku.service;

import br.com.dio.sudoku.domain.Board;
import br.com.dio.sudoku.domain.SmallSquare;
import br.com.dio.sudoku.domain.StatusEnum;

import java.util.Map;

public class BoardService {

    private final Board board;

        public BoardService(final Map<String, Integer> gameConfig) {
            this.board = new Board(initBoard(gameConfig));
        }

    private SmallSquare[][] initBoard(Map<String, Integer> gameConfig) {

        SmallSquare[][] boardInit = new SmallSquare[9][9];

        for (int i = 0; i < boardInit.length; i++) {
            for (int j = 0; j < boardInit[i].length; j++) {
                String boardMainPositionLine = Integer.toString(i);
                String boarMainPositionColumn = Integer.toString(j);
                String boardMainPositionKey = boardMainPositionLine + "," + boarMainPositionColumn;

                if (gameConfig.containsKey(boardMainPositionKey)) {
                    SmallSquare smallSquare = new SmallSquare(gameConfig.get(boardMainPositionKey), true);
                    boardInit[i][j] = smallSquare;
                } else {
                    boardInit[i][j] = new SmallSquare(0, false);
                }
            }
        }
        return boardInit;
    }

        public SmallSquare[][] getBoardWithSmallSquares(){
            return this.board.getBoard();
        }

        public void reset(){
            board.clearNumbers();
        }

        public StatusEnum statusGame(){
            return board.statusGame();
        }

        public boolean canFinishGame(){
            return board.canFinishGame();
        }
    }


