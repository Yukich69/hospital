package com.solvd.hospital.service;

import com.solvd.hospital.structure.PatientRoom;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Patient;

import java.util.Objects;

public class Referral extends Service {
    private Doctor doctor;

    public Referral(){
    }

    public Referral(Patient patient, PatientRoom room, Doctor doctor) {
        super(room, patient);
        this.doctor = doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[patient=" + getPatient().toString() + ",doctor=" + getDoctor().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatient().hashCode(), getDoctor().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referral refferal = (Referral) o;
        return hashCode() == refferal.hashCode();
    }
}
