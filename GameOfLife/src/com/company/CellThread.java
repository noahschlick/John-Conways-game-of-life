package com.company;
// The cell thread processes the cell
// writes the new cell to the text
// file

public class CellThread implements Runnable {
    ICell cell;
    int max;
    private volatile int value;
    FileWriterGOL fw;
    CellThread(ICell c, int max, FileWriterGOL fw){
        cell = c;
        this.max = max;
        this.fw = fw;
    }

    @Override
    public void run() {
        synchronized (cell) {
            cell.generateSquare();
            fw.writeToFile(cell.getState());

        }
    }







}


