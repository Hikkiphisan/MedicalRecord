package model;

import java.time.LocalDate;


    public class MedicalRecordforVipPatient extends MedicalRecord {
        private String vipPackage;
        private LocalDate vipDuration;

        public MedicalRecordforVipPatient(int recordNumberOder, String recordId, String patientId, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reason, String vipPackage, LocalDate vipDuration) {
            super(recordNumberOder, recordId, patientId, patientName, admissionDate, dischargeDate, reason);
            this.vipPackage = vipPackage;          //goi vip 1, 2,3
            this.vipDuration = vipDuration;         //thoi han vip
        }

        @Override
        public String toCSV() {
            return recordNumberOder + "," + recordId + "," + patientId + "," + patientName + "," + admissionDate + "," + dischargeDate + "," + reason + "," + vipPackage + "," + vipDuration;
        }
    }

