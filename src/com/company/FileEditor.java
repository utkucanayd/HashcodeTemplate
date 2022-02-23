package com.company;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileEditor {

    private String readFileName;
    private String writeFileName;


    public FileEditor(String readFileName, String writeFileName) {
        this.readFileName = "././hashcodeFile/" + readFileName;
        this.writeFileName = "././hashcodeFile/" + writeFileName;
    }

    //function to read the file
    public ArrayList<ArrayList<String>> readFile() throws Exception {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.readFileName));
            String line;
            ArrayList<ArrayList<String>> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(new ArrayList<>(Arrays.stream(line.split(" ")).collect(Collectors.toList())));
            }
            bufferedReader.close();
            return lines;
        } catch (Exception e) {
            System.out.println("File not found");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    System.out.println("Error while closing the file");
                }
            }
        }
        return null;
    }

    public void writeFile(ArrayList<ArrayList<String>> lines) throws Exception {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.writeFileName);
            for (ArrayList<String> line : lines) {
                for (String word : line) {
                    fileWriter.write(word + " ");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("File not found");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error while closing the file");
                }
            }
        }

    }

    public String getReadFileName() {
        return readFileName.substring(readFileName.lastIndexOf("/") + 1);

    }

    public void setReadFileName(String readFileName) {
        this.readFileName = "././hashcodeFile/" + readFileName;
    }

    public String getWriteFileName() {
        return writeFileName.substring(writeFileName.lastIndexOf("/") + 1);
    }

    public void setWriteFileName(String writeFileName) {
        this.writeFileName = "././hashcodeFile/" + writeFileName;
    }
}
