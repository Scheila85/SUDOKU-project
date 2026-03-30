package br.com.dio.sudoku.ui.costum.button;

//import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class CheckGameStatusButton extends JButton {

    public CheckGameStatusButton(final ActionListener actionListener){
        this.setText("Check game status");
        this.addActionListener(actionListener);
    }
}
