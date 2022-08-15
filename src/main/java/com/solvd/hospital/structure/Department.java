package com.solvd.hospital.structure;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private List<Doctor> doctorList;
    private List<Nurse> nurseList;

    public Department() {

    }


    public Department(String name, List<Doctor> doctorList, List<Nurse> nurseList) {
        if(employeeLimit(doctorList.size() + nurseList.size())) {
            throw new EmployeeLimitException("Department is full");
        }
        this.name = name;
        this.doctorList = doctorList;
        this.nurseList = nurseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        if(doctorOrNurseLimit(doctorList.size())) {
            throw new EmployeeLimitException("Department is full");
        }
        this.doctorList = doctorList;
    }

    public List<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<Nurse> nurseList) {
        if(doctorOrNurseLimit(nurseList.size())) {
            throw new EmployeeLimitException("Department is full");
        }
        this.nurseList = nurseList;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",doctors=" + getDoctorList().toString()
                +  ",nurses=" + getNurseList().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNurseList().hashCode(), getName().hashCode(), getNurseList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department department = (Department) o;
        return hashCode() == department.hashCode();
    }

    private boolean employeeLimit(int size) {
        return size > 20;
    }

    private boolean doctorOrNurseLimit(int size) {
        return size > 10;
    }

}
