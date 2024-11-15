package view;

import controller.*;

import java.util.Scanner;


public class MedicalRecordApp {
    public static void main(String[] args) {
//        MedicalRecordManager manager = new MedicalRecordManager();
        Scanner scanner = new Scanner(System.in);

        String filePath = "D:\\CodeGym\\Module 2\\MedicalRecord\\src\\resources\\newmedical_records.csv";
        while (true) {
            System.out.println("1. Them moi");
            System.out.println("2. Xoa");
            System.out.println("3. Xem danh sach cac benh an");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(scanner.nextLine());



            switch (choice) {
                case 1:
//                    CSVFileCreator.createCSVFile(filePath); //dung hang co san ma khong phai nhap tu ban phim thi dung cai nay
                    PrinttoFileCSV.printtoFileCSV(filePath);




                    break;
                case 2:
                    System.out.print("Nhap ma benh an muon xoa: ");
                    String recordNumber = scanner.nextLine();
                    DeletePatientByRecordNumber.deletePatientByRecordNumber(filePath,recordNumber);
                    System.out.println("Da delete benh an co ma la: " + recordNumber);
                    break;
                case 3:
//                    String oLdfilePath = "D:\\CodeGym\\Module 2\\MedicalRecord\\src\\resources\\medical_records.csv";
                    ReadAndDisplayCSV.readAndDisplayCSV(filePath);
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh vi loi.");
                    return;
                default:
                    System.out.println("Lua chon khong chisnh xac.");
            }
        }
    }
}
