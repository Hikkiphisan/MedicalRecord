package controller;

import java.io.*;

public class DeletePatientByRecordNumber {
    public static void deletePatientByRecordNumber(String filePath, String recordNumber) {
        File inputFile = new File(filePath);
        File tempFile = new File("D:\\CodeGym\\Module 2\\MedicalRecord\\src\\resources\\supernewmedical_records.csv");
//
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;


            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");


                if (data[0].equals(String.valueOf(recordNumber))) {
                    continue;
                }

                writer.write(currentLine + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}
