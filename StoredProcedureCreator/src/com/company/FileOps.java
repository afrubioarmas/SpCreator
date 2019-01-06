package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOps {

    String _filePath;

    public FileOps(String filePath) {
        this._filePath = filePath;


        File f = new File(_filePath);
        f.delete();
    }

    public void writeLn(String toWrite){


        FileWriter fw;
        try {

            fw = new FileWriter(_filePath,true);

            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(toWrite);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String toWrite){

        File file = new File(_filePath);
        FileWriter fw;
        try {

            fw = new FileWriter(_filePath,true);


            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(toWrite);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
