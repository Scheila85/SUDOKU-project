package br.com.dio.sudoku.ui.costum.panel;

import br.com.dio.sudoku.ui.costum.input.NumberText;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class SudokuSection extends JPanel {
//guarda os quadradinhos

        public SudokuSection(final List<NumberText> textFields){
            Dimension dimension = new Dimension(178,178);
            this.setSize(dimension);
            this.setPreferredSize(dimension);
            this.setBorder(new LineBorder(Color.black,2, true));
            this.setVisible(true);
            textFields.forEach(tf -> this.add(tf));
        }

}
