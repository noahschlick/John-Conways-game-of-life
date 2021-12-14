package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String filePath = "";
    private final int size = 20;
    FileManager(String path) {
        filePath = path;
    }

    public int[][] ReadToArray() {
        int x = 0;
        int[][] array = new int[size][size];
        String[] arrayOfStrings = new String [size];
        String st;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((st = br.readLine()) != null) {
                arrayOfStrings[x] = st;
                x++;
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (arrayOfStrings[i].charAt(j) == 'O') {
                        array[i][j] = 0;
                    } else {
                        array[i][j] = 1;
                    }
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public void writeToFile(int[][] array) {
        try {
            FileWriter myWriter = new FileWriter("Cells.txt");
            for(int i = 0; i < size; i++){
                for(int j =0; j < size; j++) {
                    if (array[i][j] == 0) {
                        myWriter.write('O');
                    } else {
                        myWriter.write('X');
                    }
                }
                myWriter.write('\n');
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
