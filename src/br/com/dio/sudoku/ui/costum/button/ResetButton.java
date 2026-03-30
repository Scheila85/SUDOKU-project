package br.com.dio.sudoku.ui.costum.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {

    public ResetButton(final ActionListener actionListener){
        this.setText("Reset game");
        this.addActionListener(actionListener);
    }

}
