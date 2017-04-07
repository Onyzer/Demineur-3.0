/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author onyze
 */
public class MenuBar extends JMenuBar implements ActionListener {

    private JMenuItem beginner;
    private JMenuItem intermediate;
    private JMenuItem expert;
    private JMenuItem custom;
    private JMenu newMenu;

    public JMenuItem getBeginner() {
        return beginner;
    }

    public JMenuItem getIntermediate() {
        return intermediate;
    }

    public JMenuItem getExpert() {
        return expert;
    }

    public JMenuItem getCustom() {
        return custom;
    }
    
    public MenuBar() {
        JMenu gameMenu = new JMenu("Game");
        this.newMenu = new JMenu("New");
        this.beginner = new JMenuItem("Beginner");
        this.intermediate = new JMenuItem("Intermediate");
        this.expert = new JMenuItem("Expert");
        
        this.custom = new JMenuItem("Custom");
        
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener((ActionEvent ev) -> {
            System.exit(0);
        });

        newMenu.add(beginner);
        newMenu.add(intermediate);
        newMenu.add(expert);
        newMenu.add(custom);

        gameMenu.add(newMenu);
        gameMenu.add(quit);

        this.add(gameMenu);
    }

    public JMenu getNewMenu() {
        return newMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
