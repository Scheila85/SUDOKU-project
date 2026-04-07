package br.com.dio.sudoku;

import br.com.dio.sudoku.ui.costum.screen.MainScreen;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UserInterfaceMain {

    static void main(String[] args) {

        final Map<String, Integer> gameConfig = new HashMap<>();

        for (String position : args) {
            String [] partes = position.split(",");
            String key = partes[0] +","+ partes[1];
            int value = Integer.parseInt(partes[2]);
            gameConfig.put(key,value);
        }

        MainScreen mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }
}
