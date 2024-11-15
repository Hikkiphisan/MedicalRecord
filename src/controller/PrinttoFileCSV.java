package controller;

import exception.DuplicateMedicalRecordException;
import model.MedicalRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrinttoFileCSV {
    public static void printtoFileCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
             Scanner scanner = new Scanner(System.in)) {

            writer.write("Record Number,Record ID,Patient ID,Patient Name,Admission Date,Discharge Date,Reason,Additional Info");
            writer.newLine();

            System.out.print("Nhap so thu tu cua benh an: ");
            int recordCount = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 1; i <= recordCount; i++) {
                System.out.println("Nhap thong tin cho benh an thu " + i);

                System.out.print("Ma Benh An (Vi du: BA-001): ");
                String recordID = scanner.nextLine().trim();

                System.out.print("Ma Benh Nhan (Vi du: BN-435): ");
                String patientID = scanner.nextLine().trim();

                System.out.print("Ten Benh Nhan: ");
                String patientName = scanner.nextLine().trim();

                System.out.print("Ngay nhap vien (Theo cu phap la dd/MM/yyyy): ");
                String admissionDate = scanner.nextLine().trim();

                System.out.print("Ngay ra vien (Theo cu phap la dd/MM/yyyy): ");
                String dischargeDate = scanner.nextLine().trim();

                System.out.print("Ly do: ");
                String reason = scanner.nextLine().trim();

                System.out.print("Thong tin goi VIP (VIP I, VIP II, VIP III hoặc số tiền): ");
                String additionalInfo = scanner.nextLine().trim();

                //Validate
                boolean isVip = additionalInfo.startsWith("VIP");


                if (MedicalRecordDataValidate.validateRecord(recordID, patientID, admissionDate, dischargeDate, additionalInfo, isVip)) {

                    writer.write(i + "," + recordID + "," + patientID + "," + patientName + ","
                            + admissionDate + "," + dischargeDate + "," + reason + "," + additionalInfo);
                    writer.newLine();
                } else {
                    System.out.println("Thong tin cho benh an thu " + i + " khong hop le. Khong ghi vao file.");
                }
            }


            System.out.println("File CSV duoc tao thanh cong!");
        } catch (IOException e) {
            System.err.println("Error ghi file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Khong dung dinh dang so nguyen.");
//        } catch (DuplicateMedicalRecordException e) {
//            System.err.println(e.getMessage());
//        }

//        List<MedicalRecord> records = new ArrayList<>();
//        for (MedicalRecord r : records) {
//            if (r.getRecordId().equals(record.getRecordId())) {
//                throw new DuplicateMedicalRecordException("Benh an da ton tai.");
//            }
//        }
        }

    }
}
