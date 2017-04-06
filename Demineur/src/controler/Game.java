/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JFrame;
import model.Grid;
import view.GraphicalGridView;
import view.consoleView;

/**
 *
 * @author onyze
 */
public class Game{
    private Grid grille;
    
    public Game(int xSize, int ySize, int bombs) {
        this.grille = new Grid(xSize, ySize, bombs);
    }
    
    public void playConsole(){
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
    }
    
    public void playGraphical() {

        JFrame frame = new JFrame("Démineur");
        GraphicalGridView graph = new GraphicalGridView(grille);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(graph);
        grille.addObserver(graph);
        frame.setVisible(true);
    }
}
