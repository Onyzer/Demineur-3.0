/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import model.Grid;

/**
 *
 * @author onyze
 */
public class consoleView implements Observer {
    
    private Grid grille;
    
    /**
     *
     * @param g
     */
    public consoleView(Grid g){
        this.grille = g;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.grille.toString());
    }
    
}
