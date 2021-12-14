package com.company;

public class TopRightCell implements ICell {
    private int[][] array;
    private int i;
    private int j;

    private int aliveTotal = 0;
    private boolean alive;
    private int postState = 0;

    TopRightCell(int i, int j, int[][] array) {
        this.i = i;
        this.j = j;
        this.array = array;
    }
    public void generateSquare(){

        for(int x = 0; x <= 1; x++){
            for (int y = -1; x <= 0; x++){
                if(x == 0 && y == 0) {
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
