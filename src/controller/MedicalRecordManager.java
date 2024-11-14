//package controller;
//
//import exception.DuplicateMedicalRecordException;
//import model.MedicalRecord;
//
//import java.io.*;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//    public class MedicalRecordManager {
//        private List<MedicalRecord> records = new ArrayList<>();
//        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        public void addRecord(MedicalRecord record) throws DuplicateMedicalRecordException {
//            for (MedicalRecord r : records) {
//                if (r.getRecordId().equals(record.getRecordId())) {
//                    throw new DuplicateMedicalRecordException("Benh an da ton tai.");
//                }
//            }
//            records.add(record);
//            writeToFile();
//        }
//
//
//
//
//
//        public static void readAndDisplayCSV(String filePath) {
//            String line;
//            String delimiter = ","; // Dấu phân cách của file CSV
//
//            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//                while ((line = br.readLine()) != null) {
//                    // Tách các cột trong một dòng
//                    String[] columns = line.split(delimiter);
//
//                    // In từng cột ra màn hình
//                    for (String column : columns) {
//                        System.out.print(column + " ");
//                    }
//                    System.out.println();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        private void writeToFile() {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\CodeGym\\Module 2\\MedicalRecord\\src\\resources\\newmedical_records.csv", true))) {
//                for (MedicalRecord record : records) {
//                    writer.write(record.toCSV());
//                    writer.newLine();
//                }
//            } catch (IOException e) {
//                System.err.println("Khong doc duoc File");
//            }
//        }
//    }
//
