package br.com.dio.sudoku.domain;

public class SmallSquare {

    private int currentValue;
    private final boolean isFixedValue;

    public SmallSquare(int squareValue, final boolean isFixedValue){
        this.currentValue =squareValue;
        this.isFixedValue=isFixedValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public boolean getIsFixedValue(){
        return isFixedValue;
    }

    @Override
    public String toString() {
        return String.format("SmallSquare{actualValue= %d, isFixedValue=%s}", currentValue,isFixedValue);
    }
}
