/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.webkit.event.WCMouseEvent.BUTTON1;
import controler.Game;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON1;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Cell;
import model.Grid;

/**
 *
 * @author onyze
 */
public class GraphicalGridView extends JPanel implements Observer, ActionListener, MouseListener{

    private Grid grille;

    public GraphicalGridView(Grid grille) {
        this.grille = grille;
        this.setLayout(new GridLayout(grille.getxSize(), grille.getySize()));

        for (int i = 0; i < grille.getxSize(); i++) {
            for (int j = 0; j < grille.getySize(); j++) {
                GraphicalCellView gcv = new GraphicalCellView(grille.getCell(i, j));
                gcv.addActionListener(this);
                gcv.addMouseListener(this);
                this.add(gcv);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GraphicalCellView gcv = (GraphicalCellView)e.getSource();
        Cell cell = gcv.getCell();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GraphicalCellView gcv = (GraphicalCellView)e.getSource();
        Cell cell = gcv.getCell();
        if(SwingUtilities.isLeftMouseButton(e)){
                grille.show(cell.getX(), cell.getY());
        }
        if(SwingUtilities.isRightMouseButton(e)){
            switch(cell.isMarked()){
                case 0:
                    grille.markBomb(cell.getX(), cell.getY());
                    break;
                case 1:
                    grille.markDoubt(cell.getX(), cell.getY());
                    break;
                case 2:
                    grille.unmark(cell.getX(), cell.getY());
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
