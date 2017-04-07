/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author onyze
 */
public class CustomGameFrame extends JFrame {

    private CustomGamePanel cgp = new CustomGamePanel();
    private int rows = 9;
    private int columns = 19;
    private int mines = 76;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    private class CustomGamePanel extends JPanel {

        private int rows = 9;
        private int columns = 19;
        private int mines = 76;

        public CustomGamePanel() {
            this.setLayout(new GridLayout(4, 2));
            JSlider lines = new JSlider(JSlider.HORIZONTAL, 9, 24, 9);
            lines.setMinorTickSpacing(1);
            lines.setMajorTickSpacing(2);
            lines.setPaintTicks(true);
            lines.setPaintLabels(true);
            lines.setLabelTable(lines.createStandardLabels(10));
            this.add(lines);
            JLabel lines_lbl = new JLabel("Rows");
            add(lines_lbl);
            add(lines);

            JSlider columns_slider = new JSlider(JSlider.HORIZONTAL, 9, 30, 19);
            columns_slider.setMinorTickSpacing(1);
            columns_slider.setMajorTickSpacing(2);
            columns_slider.setPaintTicks(true);
            columns_slider.setPaintLabels(true);
            columns_slider.setLabelTable(lines.createStandardLabels(10));
            this.add(columns_slider);
            JLabel columns_lbl = new JLabel("Columns");
            add(columns_lbl);
            add(columns_slider);

            JSlider mines_slider = new JSlider(JSlider.HORIZONTAL, 9, 30, 19);
            mines_slider.setMinorTickSpacing(1);
            mines_slider.setMajorTickSpacing(2);
            mines_slider.setPaintTicks(true);
            mines_slider.setPaintLabels(true);
            mines_slider.setLabelTable(lines.createStandardLabels(10));
            this.add(mines_slider);
            JLabel mines_lbl = new JLabel("Mines");
            add(mines_lbl);
            add(mines_slider);

        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }

        public int getMines() {
            return mines;
        }
    }

    public CustomGameFrame() {
        super("Custom Game");

        this.add(cgp);
        this.setSize(400, 250);
        this.setVisible(true);
        JButton button = new JButton("Valider");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rows = cgp.getRows();
                columns = cgp.getColumns();
                mines = cgp.getMines();
                setVisible(false);
            }
        });
        add(button);
        cgp.add(button);
    }
}
