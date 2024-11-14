package controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class MedicalRecordDataValidate {



        private static final Pattern BA_PATTERN = Pattern.compile("^BA-\\d{3}$");
        private static final Pattern BN_PATTERN = Pattern.compile("^BN-\\d{3}$");
        private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

        public static boolean validateRecord(String recordId, String patientId, String admissionDate,
                                             String dischargeDate, String vipPackage, boolean isVip) {
            boolean isValid = true;

            if (!BA_PATTERN.matcher(recordId).matches()) {
                System.out.println("Lỗi: Mã bệnh án không đúng định dạng BA-XXX.");
                isValid = false;
            }

            if (!BN_PATTERN.matcher(patientId).matches()) {
                System.out.println("Lỗi: Mã bệnh nhân không đúng định dạng BN-XXX.");
                isValid = false;
            }


            Date admission = parseDate(admissionDate);
            if (admission == null) {
                System.out.println("Lỗi: Ngày nhập viện không đúng định dạng dd/MM/yyyy.");
                isValid = false;
            }

            Date discharge = parseDate(dischargeDate);
            if (discharge == null) {
                System.out.println("Khong dung dinh dajng ngay thang.");
                isValid = false;
            }

            if (admission != null && discharge != null && admission.after(discharge)) {
                System.out.println("Ngay nhap vien khon duoc nho hon ngay xuat vien");
                isValid = false;
            }


            if (isVip && !isValidVipPackage(vipPackage)) {
                System.out.println("GOI VIP KHONG HOJP LE.");
                isValid = false;
            }

            return isValid;
        }

        private static Date parseDate(String dateStr) {
            try {
                return DATE_FORMAT.parse(dateStr);
            } catch (ParseException e) {
                return null;
            }
        }

        private static boolean isValidVipPackage(String vipPackage) {
            return "VIP I".equals(vipPackage) || "VIP II".equals(vipPackage) || "VIP III".equals(vipPackage);
        }

    }

