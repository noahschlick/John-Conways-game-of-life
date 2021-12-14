/*
The class represent to 2d grid of cells. It processes
a 2d grid of cell objects which will process its state
in the next turn.
 */
package com.company;
import java.io.FileReader;
import java.io.IOException;

public class Cells {
    private final int size = 20;
    private int[][] a = new int[size][size];
    Thread [][] cellThreads = new Thread[size][size];
    ICell [][] cellArray = new ICell[size][size];

    Cells(int[][] array) {
        a = array;
    }

    // The methods processes the grid to the next iteration
    public void processCells(int max, FileWriterGOL fw) {


        int [][] array = a;

        // Check position of cell
        for(int i = 0; i < size; i++ )
        {
            for(int j = 0; j < size; j++) {
                // Check of corners
                if (i == 0 && j == 0) {
                    cellArray[i][j] = new TopLeftCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (i == 0 && j == size-1) {
                    cellArray[i][j] = new TopRightCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (i == size-1 && j == 0) {
                    cellArray[i][j] = new BottomLeftCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (i == size-1 && j == size-1) {
                    cellArray[i][j] = new BottomRightCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (i == 0 && j > 0 && j < size-1) {
                    cellArray[i][j] = new TopEdgeCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (j == 0 && i > 0 && i < size-1) {
                    cellArray[i][j] = new LeftEdgeCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (j == size-1 && i > 0 && i < size-1) {
                    cellArray[i][j] = new RightEdgeCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else if (i == size-1 && j > 0 && j < size-1) {
                    cellArray[i][j] = new BottomEdgeCell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                } else {
                    cellArray[i][j] = new Cell(i,j,a);
                    cellThreads[i][j] = new Thread(new CellThread(cellArray[i][j], max, fw));
                }
            }
        }

        // Copy next turn to array
        for(int i = 0; i < size; i++ ) {
            for(int j = 0; j < size; j++) {
                    cellThreads[i][j].start();
                    try {
                        cellThreads[i][j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            fw.newLine();
        }

    }







}
