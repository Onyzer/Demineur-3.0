/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import model.Cell;

/**
 *
 * @author onyze
 */
public class GraphicalCellView extends JButton{

    private final Cell cell;

    public GraphicalCellView(Cell cell) {
        this.cell = cell;
    }
    
    public Cell getCell(){
        return this.cell;
    }
}
