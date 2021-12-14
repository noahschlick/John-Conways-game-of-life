package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
// Noah Schlickeisen
// Dec-1-2021
// Game of Life
// Cells as threads

/*
This program reads a 20 by 20 text file containing O or X
The program process the grid according to the rules in the
game of life. Each cell is an individual thread.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Read File
        FileManager fm = new FileManager("Cells.txt");
        int[][] array = fm.ReadToArray();
        FileWriterGOL fw = new FileWriterGOL("Cells.txt");


        int num = 0;

        // Instantiate cell grid
        Cells cells = new Cells(array);

        // Get number of iterations
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of iterations: ");

        if (s.hasNextInt()){
            num = s.nextInt();
        } else {
            while (!s.hasNextInt()) {
                System.out.println("I need an int, please try again.");
                s.nextLine();
            }
        }

        // Depending on the number of iterations
        // the cells will be re-written to Cells.txt
        for(int i = 0; i < num; i++) {
            fw = new FileWriterGOL("Cells.txt");
            cells.processCells(num, fw);
            fw.closeFile();

            fm = new FileManager("Cells.txt");
            array = fm.ReadToArray();
            cells = new Cells(array);
        }


    }
}
