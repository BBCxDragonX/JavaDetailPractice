package com.dreamboat.serviceNmain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVtoText {
    String csvFilePath = "D:\\CodeDump\\JavaDetailPractice\\data\\Reader.csv";
    String outputFilePath = "D:\\CodeDump\\JavaDetailPractice\\data\\outputText.txt";
    public static void main(String[] args) throws IOException {CSVtoText CTT = new CSVtoText();}
    CSVtoText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        String line;
        while((line = reader.readLine())!=null){
            String[] row = line.split(",");
            String outputLine =String.join("|",row);
            writer.write(outputLine);
            writer.newLine();
        }
        reader.close();
        writer.close();
        System.out.println("Data written to "+outputFilePath);
    }

}
