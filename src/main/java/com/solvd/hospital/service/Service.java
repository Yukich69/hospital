package com.solvd.hospital.service;

import com.solvd.hospital.structure.PatientRoom;
import com.solvd.hospital.people.Patient;

import java.util.Objects;

public abstract class Service {
    private PatientRoom room;
    private Patient patient;


    public Service(){
    }

    public Service(PatientRoom room, Patient patient){
        this.room = room;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public PatientRoom getRoom() {
        return room;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public void setRoom(PatientRoom room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[room=" + getRoom().toString() + ",patient=" + getPatient() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoom().hashCode(), getPatient().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return hashCode() == service.hashCode();
    }
}
