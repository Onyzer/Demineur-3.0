/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author onyze
 */
public class Grid extends Observable {

    private int xSize;
    private int ySize;
    private Cell[][] grid;
    private int nbBomb;
    public boolean lost;
    public boolean won;
    private boolean first;

    public Grid() {
        this(10, 10, 20);
    }

    public Grid(int xSize, int ySize) {
        this(xSize, ySize, 20);
    }

    public Grid(int xSize, int ySize, int bombPercent) {
        this.lost = false;
        this.first = true;
        this.xSize = xSize;
        this.ySize = ySize;
        this.nbBomb = this.xSize * this.ySize * bombPercent / 100;
        this.grid = new Cell[this.xSize][this.ySize];
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                this.grid[i][j] = new Cell(i, j);
            }
        }
    }

    public void generateBomb(int x, int y) {
        ArrayList<Cell> emptyCells = new ArrayList();
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                emptyCells.add(this.grid[i][j]);
            }
        }
        ArrayList<Cell> n = getNeighbour(x, y);
        n.forEach((neighbour) -> {
            emptyCells.remove(neighbour);
        });
        emptyCells.remove(grid[x][y]);
        while (nbBomb > 0) {
            Random rand = new Random();
            int nbRand = rand.nextInt(emptyCells.size());
            Cell c = emptyCells.get(nbRand);
            emptyCells.remove(c);
            this.grid[c.getX()][c.getY()].setBomb();
            ArrayList<Cell> neighbours = this.getNeighbour(c.getX(), c.getY());//new ArrayList();
            neighbours.forEach((neighbour) -> {
                if (neighbour.getRisk() != -1) {
                    neighbour.addRisk();
                }
            });
            nbBomb--;
        }
    }

    private ArrayList<Cell> getNeighbour(int x, int y) {
        ArrayList<Cell> neighbours = new ArrayList();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ((i >= 0) && (i < xSize) && (j >= 0) && (j < ySize)) {
                    if ((i != x) || (j != y)) {
                        neighbours.add(this.grid[i][j]);
                    }
                }
            }
        }
        return neighbours;
    }

    public void showCell(int x, int y) {
        if (first) {
            generateBomb(x, y);
            first = false;
        }
        Cell c = grid[x][y];
        if (c.isHidden()) {
            c.setHidden(false);
            if (c.isMarked() != 0) {
                System.out.println("u can't show a marked cell");
            } else {
                switch (c.getRisk()) {
                    case 0:
                        ArrayList<Cell> neighbours = this.getNeighbour(c.getX(), c.getY());//new ArrayList();
                        neighbours.forEach((Cell neighbour) -> {
                            if (neighbour.isHidden()) {
                                showCell(neighbour.getX(), neighbour.getY());
                            }
                        });
                        break;
                    case -1:
                        System.out.println("perdu");
                        this.lost = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void isWon() {
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                if ((this.grid[i][j].isHidden()) && (this.grid[i][j].getRisk() != -1)) {
                    won = false;
                    return;
                }
            }
        }
        won = true;
    }

    public void show(int x, int y) {
        showCell(x, y);
        setChanged();
        notifyObservers();
        System.out.println("show de :" + x + " " + y);
    }

    public void markBomb(int x, int y) {
        Cell c = grid[x][y];
        if (c.isMarked() != 1) {
            c.setMarked(1);
            c.setHidden(false);
            setChanged();
            notifyObservers();
            System.out.println("markbomb de :" + x + " " + y);
        }
    }

    public void markDoubt(int x, int y) {
        Cell c = grid[x][y];
        if (c.isMarked() != 2) {
            c.setMarked(2);
            c.setHidden(false);
            setChanged();
            notifyObservers();
            System.out.println("markDoubt de :" + x + " " + y);
        }
    }

    public void unmark(int x, int y) {
        Cell c = grid[x][y];
        if (c.isMarked() != 0) {
            c.setMarked(0);
            c.setHidden(true);
            setChanged();
            notifyObservers();
            System.out.println("unmark de :" + x + " " + y);
        }
    }

    public void setCell(Cell c, int i, int j) {
        grid[i][j] = c;
    }

    @Override
    public String toString() {
        String gridDisplay = new String();
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                gridDisplay += " ";
                if (!grid[i][j].isHidden()) {
                    switch (grid[i][j].getRisk()) {
                        case -1:
                            switch (grid[i][j].isMarked()) {
                                case 2:
                                    gridDisplay += "?";

                                    break;
                                case 1:
                                    gridDisplay += "!";

                                    break;
                                default:
                                    gridDisplay += "X";

                                    break;
                            }
                        case 0:
                            gridDisplay += ".";
                            break;
                        default:
                            gridDisplay += Integer.toString(grid[i][j].getRisk());
                            break;
                    }
                } else {
                    gridDisplay += "#";
                }
            }
            gridDisplay += "\n";
            gridDisplay += "\n";

        }
        return gridDisplay;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

}
