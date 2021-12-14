/*
The cell object represents a cell tthat is not on the edge
or in the corner of the grid. It processes the state of the
cell in the next iteration
 */
package com.company;

public class Cell implements ICell{
    private int[][] array;
    private int i;
    private int j;

    private int aliveTotal = 0;
    private boolean alive;
    private int postState = 0;

    // Constructor counts alive neighbors
    Cell(int i, int j, int[][] array) {
        this.i = i;
        this.j = j;
        this.array = array;
    }

    // Generates cells next state
    public void generateSquare(){

        for(int x = -1; x <= 1; x++){
            for (int y = -1; y <= 1; y++){
                if (x==0 && y==0) {
                    if (array[i][j] == 1) {
                        alive = true;
                    } else {
                        alive = false;
                    }
                } else if (array[i+x][j+y] == 1) {
                    aliveTotal++;
                }

            }
        }

        if((alive) && aliveTotal < 2) {
            postState = 0;
        } else if ((alive == true) && aliveTotal == 2){
            postState = 1;
        } else if  ((alive == true) && aliveTotal == 3) {
            postState = 1;
        } else if ((alive) && aliveTotal > 3) {
            postState = 0;
        } else if (!(alive) && aliveTotal == 3) {
            postState = 1;
        } else {
            postState = 0;
        }
    }

    public int getState(){
        return postState;
    }


}
