package br.com.dio.sudoku.ui.costum.input;

import br.com.dio.sudoku.domain.SmallSquare;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class NumberTextField extends JTextField {

    private final SmallSquare smallSquare;

    public NumberTextField(final SmallSquare smallSquare){
        this.smallSquare=smallSquare;
        Dimension dimension = new Dimension(47, 47);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!smallSquare.getIsFixedValue());//altera se não for fixo
        if(smallSquare.getIsFixedValue()){
            this.setText(Integer.toString(smallSquare.getActualValue()));
        }

        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeSmallSquare();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeSmallSquare();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeSmallSquare();
            }

            private void changeSmallSquare(){
                if (getText().isEmpty()){
                    smallSquare.setActualValue(0);
                    return;
                }
                smallSquare.setActualValue(Integer.parseInt(getText()));
            }
        });
    }


}
