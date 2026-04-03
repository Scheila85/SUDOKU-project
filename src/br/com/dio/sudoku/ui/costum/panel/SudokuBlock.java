package br.com.dio.sudoku.ui.costum.panel;

import br.com.dio.sudoku.ui.costum.input.NumberTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class SudokuBlock extends JPanel {
//guarda os quadradinhos

        public SudokuBlock(final List<NumberTextField> textFields) {
            Dimension dimension = new Dimension(164, 164);
            this.setSize(dimension);
            this.setPreferredSize(dimension);
            this.setBorder(new LineBorder(Color.black, 2, true));
            this.setVisible(true);
            textFields.forEach(tf -> this.add(tf));
        }

}
