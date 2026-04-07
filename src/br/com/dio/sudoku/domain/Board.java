package br.com.dio.sudoku.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import static br.com.dio.sudoku.domain.StatusEnum.COMPLETE;

public class Board {

    private SmallSquare[][] board; //= new SmallSquare[9][9];

    public Board(SmallSquare[][] board){
        this.board=board;
    }

    public SmallSquare[][] getBoard() {
        return board;
    }

    public boolean addNewNumber(int value, int line, int column){

        SmallSquare smallSquare = board[line][column];

        if (!(smallSquare.getIsFixedValue())){
            smallSquare.setCurrentValue(value);
            return true;
        }
        return false;
    }

    public boolean removeANumber(int line, int column){

        SmallSquare smallSquare = board[line][column];

        if (!(smallSquare.getIsFixedValue())){
            smallSquare.setCurrentValue(0);
            return true;
        }
        return false;
    }

    public void clearNumbers(){

        for (SmallSquare[] line : board){
            for (SmallSquare columnSmallSquare : line){
                if(!(columnSmallSquare.getIsFixedValue())){
                    columnSmallSquare.setCurrentValue(0);
                }
            }
        }
    }

    public StatusEnum statusGame(){

        boolean thereIsEmptySmallSquare = false;
        boolean thereIsActualValueGreaterThanZero = false;

        for (SmallSquare[] line : board) {
            for (SmallSquare columnSmallSquare : line) {

                if (!columnSmallSquare.getIsFixedValue()){
                    if (columnSmallSquare.getCurrentValue() == 0) {
                        thereIsEmptySmallSquare = true;
                   } else {
                        thereIsActualValueGreaterThanZero = true;
                    }
                }
                if (thereIsEmptySmallSquare && thereIsActualValueGreaterThanZero){
                    return StatusEnum.INCOMPLETE;
                }
            }
        }

        if (!(thereIsEmptySmallSquare) && thereIsActualValueGreaterThanZero) {
            return COMPLETE;
        }
        return StatusEnum.UNSTARTED;
    }

    public boolean hasDuplicatesInLine(){

        for(int line =0; line < board.length; line++){

            Set<Integer> unicNumbersInLine = new LinkedHashSet<>();

            for (int column =0; column < board[line].length; column++){

                int columnValue = board[line][column].getCurrentValue();

                if(columnValue != 0){
                    if (unicNumbersInLine.contains(columnValue)){
                        return true; //quebra os dois laços porque já achou a resposta;
                    } else {
                        unicNumbersInLine.add(columnValue);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDuplicatesInColumn(){


        for (int column = 0; column < board.length; column++){

            Set<Integer> unicNumbersInColumn = new LinkedHashSet<>();

            for (int line = 0; line < board[column].length; line++){

                int lineValue = board[line][column].getCurrentValue();

                if (lineValue != 0){
                    if (unicNumbersInColumn.contains(lineValue)){
                        return true;
                    } else {
                        unicNumbersInColumn.add(lineValue);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDuplicatesInBlock3X3 (){

        for (int line = 0; line < board.length; line+=3){

            for (int column = 0; column < board[line].length; column+=3){

                Set<Integer> unicBlockNumbers = new LinkedHashSet<>();

                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){

                        int blockValue = board[line + i][column + j].getCurrentValue();

                        if (blockValue != 0){
                            if (unicBlockNumbers.contains(blockValue)){
                                return true;
                            } else {
                                unicBlockNumbers.add(blockValue);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

   public boolean hasErrors() {

       return hasDuplicatesInLine() | hasDuplicatesInColumn() | hasDuplicatesInBlock3X3();
   }

    public boolean canFinishGame(){

        return  statusGame() == COMPLETE && !hasErrors();
    }
}
