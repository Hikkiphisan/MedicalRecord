package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class CSVFileCreator {

        public static void createCSVFile(String filePath) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Ghi tiêu đề cột
                writer.write("Record Number,Record ID,Patient ID,Patient Name,Admission Date,Discharge Date,Reason,Additional Info");
                writer.newLine();

                // Ghi dữ liệu mẫu vào file
                writer.write("1,BA-001,BN-435,Phi Huu Loc,7/8/2016,8/8/2019,Ung thư gan giai đoạn cuối,VIP II");
                writer.newLine();
                writer.write("2,BA-112,BN-123,Dao Van Huy Hung,10/8/2019,10/8/2020,Suy thận mãn,VIP III");
                writer.newLine();
                writer.write("3,BA-223,BN-984,Le Tuan Dung,11/1/2020,8/8/2020,Covid-2019,5000000");
                writer.newLine();
                writer.write("4,BA-444,BN-153,Phan Van Luan,7/8/2017,8/8/2018,Ung thư phổi giai đoạn cuối,VIP I");
                writer.newLine();

                System.out.println("File CSV đã được tạo thành công!");
            } catch (IOException e) {
                System.err.println("Lỗi khi ghi file CSV: " + e.getMessage());
            }
        }

    }


