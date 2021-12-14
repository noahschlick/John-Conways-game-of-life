package com.company;

import java.io.FileWriter;
import java.io.IOException;
/*
Deals with writing the processed cell
back to the text file.
 */


public class FileWriterGOL {
    FileWriter myWriter;


    FileWriterGOL(String path) throws IOException {
        myWriter = new FileWriter(path);
    }

    // This is called in the thread
    public void writeToFile(int result){
        try {
            if (result == 0) {
                myWriter.write('O');
            } else {
                myWriter.write('X');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newLine(){
        try {
            myWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
