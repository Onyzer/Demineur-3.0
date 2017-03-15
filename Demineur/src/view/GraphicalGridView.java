/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import model.Grid;

/**
 *
 * @author onyze
 */
public class GraphicalGridView extends JPanel {

    private Grid grille;

    public GraphicalGridView(Grid grille) {
        this.grille = grille;
        this.setLayout(new GridLayout(grille.getxSize(), grille.getySize()));

        for (int i = 0; i < grille.getxSize(); i++) {
            for (int j = 0; j < grille.getySize(); j++) {
                this.add(new GraphicalCellView(grille.getCell(i, j)));
            }
        }

    }

}
