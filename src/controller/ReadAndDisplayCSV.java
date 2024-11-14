package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndDisplayCSV {
    public static void readAndDisplayCSV(String filePath) {
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);

                for (String column : columns) {
                    System.out.print(column + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
