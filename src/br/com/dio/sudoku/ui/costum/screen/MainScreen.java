package br.com.dio.sudoku.ui.costum.screen;

import br.com.dio.sudoku.domain.SmallSquare;
import br.com.dio.sudoku.domain.StatusEnum;
import br.com.dio.sudoku.service.BoardService;
import br.com.dio.sudoku.ui.costum.button.CheckGameStatusButton;
import br.com.dio.sudoku.ui.costum.button.FinishGameButton;
import br.com.dio.sudoku.ui.costum.button.ResetButton;
import br.com.dio.sudoku.ui.costum.frame.MainFrame;
import br.com.dio.sudoku.ui.costum.input.NumberTextField;
import br.com.dio.sudoku.ui.costum.panel.MainPanel;
import br.com.dio.sudoku.ui.costum.panel.SudokuBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainScreen {

    //private final static Dimension dimension = new Dimension(600,600);
    private final BoardService boardService;
    private final NumberTextField[][] fields = new NumberTextField[9][9];
    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetGameButton;


    public MainScreen(final Map<String, Integer> gameConfig){
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(new Dimension(500,500));
        JFrame mainFrame = new MainFrame(new Dimension(600,600),mainPanel);
        generateBlock(boardService.getBoardWithSmallSquares(), mainPanel);
        addCheckGameStatusButton(mainPanel);
        addResetGameButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void generateBlock(final SmallSquare[][] board, JPanel mainPanel) {
        for (int line = 0; line < board.length; line+=3){
            for (int column = 0; column < board[line].length; column+=3){
                List<NumberTextField> textFields = new ArrayList<>();
                for (int i=0; i<3; i++){
                    for (int j=0; j<3; j++){
                        SmallSquare smallSquare = board[line+i][column+j];
                        NumberTextField ntf = new NumberTextField(smallSquare);
                        fields[line+i][column+j] = ntf;
                        textFields.add(ntf);
                    }
                }
                SudokuBlock sudokuBlock = new SudokuBlock(textFields);
                mainPanel.add(sudokuBlock);
            }
        }
    }

    private void updateBoardUI(final SmallSquare[][] board) {
        for (int line = 0; line < board.length; line +=3) {
            for (int column = 0; column < board[line].length; column +=3) {
                for(int i=0; i < 3; i++) {
                    for (int j=0; j<3; j++) {
                        SmallSquare smallSquare = board[line+i][column+j];
                        if (!smallSquare.getIsFixedValue()) {
                            fields[line+i][column+j].setText("");
                        }
                    }
                }
            }
        }
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
         checkGameStatusButton = new CheckGameStatusButton(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                {
                    StatusEnum gameStatus = boardService.statusGame();
                    String message = switch (gameStatus){
                        case UNSTARTED -> "The game has not started yet";
                        case INCOMPLETE -> "The game is incomplete";
                        case COMPLETE -> "The game is complete";
                    };
                    JOptionPane.showMessageDialog(null,message);
                }
             }
         });
        mainPanel.add(checkGameStatusButton);
    }

    private void addFinishGameButton(JPanel mainPanel) {
         finishGameButton = new FinishGameButton(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 {
                     if (boardService.canFinishGame()){
                         JOptionPane.showMessageDialog(
                                 null,
                                 "Great Job, you won the game!");
                         resetGameButton.setEnabled(false);
                         checkGameStatusButton.setEnabled(false);
                         finishGameButton.setEnabled(false);
                     }else {
                         JOptionPane.showMessageDialog(null, "It's not possible to finish the game.\n" +
                                 "The game contains errors or is incomplete.");
                     }
                 }}
                 });
         mainPanel.add(finishGameButton);
    }

    private void addResetGameButton(JPanel mainPanel) {
        resetGameButton = new ResetButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    int dialogResult = JOptionPane.showConfirmDialog(
                        null,
                        "Do you really want to reset the game?",
                        "Reset Game",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                        );
                    if(dialogResult == 0){ //0 = s, 1 = n
                        boardService.reset();
                        updateBoardUI(boardService.getBoardWithSmallSquares());
                    }
                }
            }
        });
        mainPanel.add(resetGameButton);
    }
}

