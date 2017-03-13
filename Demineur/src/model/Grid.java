/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author onyze
 */
public class Grid {

    private int xSize;
    private int ySize;
    private Cell[][] grid;
    private int nbBomb;

    public Grid() {
        this(10, 10, 20);
    }

    public Grid(int xSize, int ySize) {
        this(xSize, ySize, 20);
    }

    public Grid(int xSize, int ySize, int bombPercent) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.nbBomb = this.xSize * this.ySize * bombPercent / 100;
        this.grid = new Cell[this.xSize][this.ySize];
        ArrayList<Cell> emptyCells = new ArrayList();
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                this.grid[i][j] = new Cell(i, j);
                emptyCells.add(this.grid[i][j]);
            }
        }
        while (nbBomb > 0) {
            Random rand = new Random();
            int nbRand = rand.nextInt(emptyCells.size());
            Cell c = emptyCells.get(nbRand);
            emptyCells.remove(c);
            this.grid[c.getX()][c.getY()].setBomb();
            ArrayList<Cell> neighbours = this.getNeighbour(c.getX(), c.getY());//new ArrayList();
            neighbours.forEach((neighbour) -> {
                neighbour.addRisk();
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
        Cell c = grid[x][y];
        if (c.isHidden()) {
            c.setHidden(false);
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
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public String toString() {
        String gridDisplay = new String();
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                if (grid[i][j].isHidden()) {
                    switch (grid[i][j].getRisk()) {
                        case -1:
                            gridDisplay += "X";
                            break;
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
        }
        return gridDisplay;
    }

}
