/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author onyze
 */
public class Cell {

    private int risk;
    private final int x;
    private final int y;
    private boolean hidden;
    private int marked;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.risk = 0;
        this.hidden = true;
        this.marked = 0;
    }

    public void setBomb() {
        this.risk = -1;
    }

    public int getRisk() {
        return risk;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void addRisk() {
        if (this.risk != -1) {
            this.risk++;
        }
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setMarked(int marked) {
        this.marked = marked;
    }
    
    public int isMarked(){
        return marked;
    }

}
