package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //string array stores the file names which are to be read
        String[] fileNames = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt"};

        //string array stores the file names which are to be written
        String[] writeFileNames = {"a-result.txt", "b-result.txt", "c-result.txt", "d-result.txt", "e-result.txt", "f-result.txt"};

        //loop to read the files
        for (int i = 0; i < fileNames.length; i++) {
            //creating a new FileEditor object, containing the read file name and write file name
            FileEditor fileEditor = new FileEditor(fileNames[i], writeFileNames[i]);
            try {
                //read file and save to 2 dimensional arraylist
                ArrayList<ArrayList<String>> file = fileEditor.readFile();

                /*
                Solution is here
                 */

                //print file
                fileEditor.writeFile(file);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
