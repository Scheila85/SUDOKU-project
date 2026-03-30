package br.com.dio.sudoku.ui.costum.screen;

import br.com.dio.sudoku.domain.StatusEnum;
import br.com.dio.sudoku.service.BoardService;
import br.com.dio.sudoku.ui.costum.button.CheckGameStatusButton;
import br.com.dio.sudoku.ui.costum.button.FinishGameButton;
import br.com.dio.sudoku.ui.costum.button.ResetButton;
import br.com.dio.sudoku.ui.costum.frame.MainFrame;
import br.com.dio.sudoku.ui.costum.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600,600);
    private final BoardService boardService;
    JButton finishGameButton;
    JButton checkGameStatusButton;
    JButton resetGameButton;

    public MainScreen(final Map<String, Integer> gameConfig){
        this.boardService = new BoardService(gameConfig);
    }


    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetGameButton(mainPanel);
        addFinishGameButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
         checkGameStatusButton = new CheckGameStatusButton(e -> {
            StatusEnum gameStatus = boardService.statusGame();
            String message = switch (gameStatus){
                case UNSTARTED -> "The game has not started yet";
                case INCOMPLETE -> "The game is incomplete";
                case COMPLETE -> "The game is complete";
            };
            JOptionPane.showMessageDialog(null,message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addFinishGameButton(JPanel mainPanel) {

         finishGameButton = new FinishGameButton( e -> {
            if (boardService.canFinishGame()){
                JOptionPane.showMessageDialog(null, "Great Job, you won the game!");
                resetGameButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            }else {
                JOptionPane.showMessageDialog(null,
                        "It's not possible finish the game. \n" +
                "The game contains errors or is incomplete.");
            }
        });
        mainPanel.add(finishGameButton);
    }

    private void addResetGameButton(JPanel mainPanel) {
        resetGameButton = new ResetButton(e -> {
            int dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Do you really want to reset the game?",
                    "Reset Game",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                    );
            if(dialogResult == 0){ //0 = s, 1 = n
                boardService.reset();
            }
        });
        mainPanel.add(resetGameButton);
    }
}
