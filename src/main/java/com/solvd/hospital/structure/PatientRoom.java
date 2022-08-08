package com.solvd.hospital.structure;

import com.solvd.hospital.people.Patient;

import java.util.List;
import java.util.Objects;

public class PatientRoom {
    private int roomNum;
    private List<Patient> patientList;

    public PatientRoom() {
    }

    public PatientRoom(int roomNum, List<Patient> patientList) {
        this.roomNum = roomNum;
        this.patientList = patientList;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[room=" + getRoomNum() + ",patients=" + getPatientList().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNum(), getPatientList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientRoom room = (PatientRoom) o;
        return hashCode() == room.hashCode();
    }
}
