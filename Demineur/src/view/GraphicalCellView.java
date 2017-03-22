/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Cell;

/**
 *
 * @author onyze
 */
public class GraphicalCellView extends JButton implements ActionListener {

    private final Cell cell;

    public GraphicalCellView(Cell cell) {
        this.cell = cell;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println(cell.getX() + " : "+cell.getY());
    }
}
