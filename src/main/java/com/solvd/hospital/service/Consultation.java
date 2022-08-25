package com.solvd.hospital.service;

import com.solvd.hospital.structure.PatientRoom;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.people.Patient;

import java.util.Objects;

public class Consultation extends Service {
    private Nurse nurse;
    private String date;

    private double price;

    public Consultation(){
    }
    public Consultation(Nurse nurse, double price){
        this.nurse = nurse;
        this.price = price;
    }

    public Consultation(PatientRoom room, Patient patient, Nurse nurse, String date) {
        super(room, patient);
        this.nurse = nurse;
        this.date = date;
    }

    public Nurse getNurse() {
        return nurse;
    }


    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[nurse=" + getNurse().toString() + ",date=" + getDate() +  ",patient=" + getPatient().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNurse().hashCode(), getPatient().hashCode(), getDate().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation consultation = (Consultation) o;
        return hashCode() == consultation.hashCode();
    }
}
