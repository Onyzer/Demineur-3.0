/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Scanner;
import model.Grid;
import view.consoleView;

/**
 *
 * @author onyze
 */
public class Game {

    public static void main(String[] args) {
        int xSize, ySize, bombs = 0;
        String action;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le super Démineur !");
        //Récupération de la taille en X
        System.out.println("Quelle sera le nombre de cellules en X ?");
        xSize = Integer.parseInt(sc.nextLine());
        System.out.println("Quelle sera le nombre de cellules en Y ?");
        ySize = Integer.parseInt(sc.nextLine());
        System.out.println("Quelle sera le pourcentage de bombes dans la grille ?");
        while (bombs > 85 || bombs <= 0) {
            try {
                bombs = Integer.parseInt(sc.nextLine());
                if (bombs > 85 || bombs <= 0) {
                    throw new BombsException();
                }
            } catch (BombsException e) {
            }

        }
        Grid grille = new Grid(xSize, ySize, bombs);
        consoleView cons = new consoleView(grille);
        grille.addObserver(cons);

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

                        grille.show(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    }
                    break;
                case "q":
                    System.out.println("Bah bravo, ça abandonne ! Pfff...");
                    grille.lost = true;
                    break;
            }
        }

    }
}
