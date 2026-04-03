package br.com.dio.sudoku.domain;

public class SmallSquare {

    private int actualValue;
    private final boolean isFixedValue;

    public SmallSquare(int squareValue, final boolean isFixedValue){
        this.actualValue=squareValue;
        this.isFixedValue=isFixedValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public boolean getIsFixedValue(){
        return isFixedValue;
    }

    @Override
    public String toString() {
        return String.format("SmallSquare{actualValue= %d, isFixedValue=%s}", actualValue,isFixedValue);
    }
}
