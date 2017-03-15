/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author onyze
 */
public class SwingView implements Observer{
     public static void main(String args[]){
         JFrame frame = new JFrame("My First frame in Java");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(300, 400);
         frame.setVisible(true);
     }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
