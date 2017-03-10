/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Scanner;

/**
 *
 * @author onyze
 */
public class Game {
    public static void main(String[] args){
        int xSize, ySize, bombs = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le super Démineur !");
        //Récupération de la taille en X
        System.out.println("Quelle sera le nombre de cellules en X ?");
        xSize = Integer.parseInt(sc.nextLine());
        System.out.println("Quelle sera le nombre de cellules en Y ?");
        ySize = Integer.parseInt(sc.nextLine());
        System.out.println("Quelle sera le pourcentage de bombes dans la grille ?");
        while(bombs >85 || bombs <=0){
            try{
                bombs = Integer.parseInt(sc.nextLine());
                if(bombs >85 || bombs <=0){
                    throw new BombsException();
                }
            }
            catch(BombsException e){}
            
        }
        Grid grille = new Grid(xSize, ySize, bombs);
    }
}
