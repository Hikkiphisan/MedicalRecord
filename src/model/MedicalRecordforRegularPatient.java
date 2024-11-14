package model;
import java.time.LocalDate;

public class MedicalRecordforRegularPatient extends MedicalRecord {
    private double hospitalFee;      //phi nhap vien

    public MedicalRecordforRegularPatient(int recordNumberOder, String recordId, String patientId, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reason, double hospitalFee) {
        super(recordNumberOder, recordId, patientId, patientName, admissionDate, dischargeDate, reason);
        this.hospitalFee = hospitalFee;
    }

    @Override
    public String toCSV() {
        return recordNumberOder + "," + recordId + "," + patientId + "," + patientName + "," + admissionDate + "," + dischargeDate + "," + reason + "," + hospitalFee;
    }
}
