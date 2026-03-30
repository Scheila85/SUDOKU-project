package br.com.dio.sudoku.ui.costum.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FinishGameButton extends JButton {

    public FinishGameButton(final ActionListener actionListener){
        this.setText("Finish game");
        this.addActionListener(actionListener);
    }
}
