package model;

import java.time.LocalDate;

public abstract class MedicalRecord {
    protected int recordNumberOder;        //cai nay la so thu tu benh an
    protected String recordId;              // ma benh an
    protected String patientId;             // ma benh nhan
    protected String patientName;
    protected LocalDate admissionDate;         // ngay vao vien
    protected LocalDate dischargeDate;           //ngay roi khoi vien
    protected String reason;                      //nguyen do

    public MedicalRecord(int recordNumberOder, String recordId, String patientId, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reason) {
        this.recordNumberOder = recordNumberOder;
        this.recordId = recordId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
    }

    public abstract String toCSV();

    public String getRecordId() {
        return recordId;
    }
}