/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import model.Grid;
import view.CustomGameFrame;
import view.GraphicalGridView;
import view.MenuBar;
import view.consoleView;

/**
 *
 * @author onyze
 */
public class Game {

    private int x = 9;
    private int y = 9;
    private int bombs = 10;
    private Grid grille;
    private GraphicalGridView graph;

    public Game() {

    }

    /*public void playConsole(){
        consoleView cons = new consoleView(grille);
        grille.addObserver(cons);
        Scanner sc = new Scanner(System.in);
        String action;
        while (!grille.lost && !grille.won) {
            System.out.println("Qu'allez vous faire ?");
            action = sc.nextLine();
            String[] parts = action.split(" ");
            switch (parts[0]) {
                case "d":
                    if (parts.length == 3) {
                        grille.show(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    }
                    break;
                case "m":
                    if (parts.length == 4) {
                        switch (parts[3]) {
                            case "x":
                                grille.markBomb(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                                break;
                            case "?":
                                grille.markDoubt(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                                break;
                            case "#":
                                grille.unmark(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                                break;
                        }
                    }
                    break;
                case "q":
                    System.out.println("Bah bravo, ça abandonne ! Pfff...");
                    grille.lost = true;
                    break;
            }
        }
    }*/
    public void playGraphical() {

        JFrame frame = new JFrame("Démineur");

        MenuBar menuBar = new MenuBar();
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        grille = new Grid(x, y, bombs);
        graph = new GraphicalGridView(grille);
        frame.add(graph);
        grille.addObserver(graph);
        frame.setVisible(true);
        menuBar.getCustom().addActionListener((ActionEvent ev) -> {
            CustomGameFrame cgf = new CustomGameFrame();
            x = cgf.getRows();
            y = cgf.getColumns();
            bombs = cgf.getMines();
            grille = new Grid(x, y, bombs);
            frame.remove(graph);
            graph = new GraphicalGridView(grille);
            frame.add(graph);
            grille.addObserver(graph);
            frame.repaint();
            frame.setVisible(true);
        });

        menuBar.getBeginner().addActionListener((ActionEvent ev) -> {
            x = 9;
            y = 9;
            bombs = 10;
            grille = new Grid(x, y, bombs);
            frame.remove(graph);
            graph = new GraphicalGridView(grille);
            frame.add(graph);
            grille.addObserver(graph);
            frame.repaint();
            frame.setVisible(true);
        });

        menuBar.getIntermediate().addActionListener((ActionEvent ev) -> {
            x = 16;
            y = 16;
            bombs = 40;
            grille = new Grid(x, y, bombs);
            frame.remove(graph);
            graph = new GraphicalGridView(grille);
            frame.add(graph);
            grille.addObserver(graph);
            frame.repaint();
            frame.setVisible(true);
        });

        menuBar.getExpert().addActionListener((ActionEvent ev) -> {
            x = 16;
            y = 30;
            bombs = 99;
            grille = new Grid(x, y, bombs);
            frame.remove(graph);
            graph = new GraphicalGridView(grille);
            frame.add(graph);
            grille.addObserver(graph);
            frame.repaint();
            frame.setVisible(true);
        });
        
    }
}
