/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.webkit.event.WCMouseEvent.BUTTON1;
import controler.Game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON1;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Cell;
import model.Grid;

/**
 *
 * @author onyze
 */
public class GraphicalGridView extends JPanel implements Observer, ActionListener, MouseListener {

    private Grid grille;
    private GraphicalCellView[][] buttons;

    public GraphicalGridView(Grid grille) {
        this.grille = grille;
        this.setLayout(new GridLayout(grille.getxSize(), grille.getySize()));
        this.buttons = new GraphicalCellView[grille.getxSize()][grille.getySize()];

        for (int i = 0; i < grille.getxSize(); i++) {
            for (int j = 0; j < grille.getySize(); j++) {
                GraphicalCellView gcv = new GraphicalCellView(grille.getCell(i, j));
                gcv.addActionListener(this);
                gcv.addMouseListener(this);
                this.add(gcv);
                buttons[i][j] = gcv;
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Grid) {
            System.out.println();
        }
        Color color[] = {Color.BLUE, Color.GREEN, Color.RED, Color.DARK_GRAY, Color.MAGENTA, Color.ORANGE};
        for (int i = 0; i < grille.getxSize(); i++) {
            for (int j = 0; j < grille.getySize(); j++) {
                this.grille.setCell(buttons[i][j].getCell(), i, j);
                Cell c = grille.getCell(i, j);
                if (!c.isHidden()) {
                    if (c.isMarked() != 0) {
                        switch (c.isMarked()) {
                            case 2:
                                buttons[i][j].setText("?");
                                buttons[i][j].setIcon(null);
                                buttons[i][j].setBackground(Color.LIGHT_GRAY);

                                break;
                            case 1:
                                buttons[i][j].setIcon(new ImageIcon("/home/luc/Luc/Cours/CIR3/Java/TP Demineur/Demineur-3.0/Demineur/src/view/img/flag.png"));
                                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                                // A que coucou Luc :3 
                                // A que coucou Milan :) 
                                break;
                            default:
                                buttons[i][j].setBackground(null);

                                break;
                        }
                    } else {

                        switch (c.getRisk()) {

                            case -1:
                                System.out.println("PERDU");
                                buttons[i][j].setIcon(new ImageIcon("/home/luc/Luc/Cours/CIR3/Java/TP Demineur/Demineur-3.0/Demineur/src/view/img/image.png"));
                                buttons[i][j].setBackground(Color.RED);
                                buttons[i][j].setText("");
                                break;
                            case 0:
                                buttons[i][j].setText("-");
                                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                                break;
                            default:
                                buttons[i][j].setText(Integer.toString(c.getRisk()));
                                buttons[i][j].setForeground(color[c.getRisk() - 1]);
                                buttons[i][j].setBackground(Color.LIGHT_GRAY);

                                //buttons[i][j].setEnabled(false);
                                break;
                        }
                    }
                } else {
                    buttons[i][j].setText("");
                }
            }
        }
        grille.isWon();
        if (grille.won) {
            System.out.println("GAGNER");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        GraphicalCellView gcv = (GraphicalCellView) e.getSource();
        Cell cell = gcv.getCell();
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        GraphicalCellView gcv = (GraphicalCellView) e.getSource();
        Cell cell = gcv.getCell();
        if (SwingUtilities.isLeftMouseButton(e)) {
            grille.show(cell.getX(), cell.getY());
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            switch (cell.isMarked()) {
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
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }
}
