package com.solvd.hospital.people;

import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Office;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Doctor extends Employee {
    private static final Logger log = LogManager.getLogger(Doctor.class);

    private static final Scanner scanner = new Scanner(System.in);
    private List<Patient>  patientList;
    private Office office;


    public Doctor(){
    }

    public Doctor(Office office, String name, boolean hasEducation, int age, Department department, double salary,
                  List<Patient>  patientList ){
        super(name, hasEducation, age, department, salary);
        if(patientLimit(patientList.size())) {
            throw new PatientLimitException("Doctor reached the limit");
        }
        this.patientList = patientList;
        this.office = office;
    }


    public List<Patient> getPatientList(){
        return patientList;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",department=" + getDepartment().toString()
                +  ",salary=" + getSalary() + ",office=" + getOffice().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getOffice().hashCode(), getDepartment().hashCode(), getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return hashCode() == doctor.hashCode();
    }


    public Patient addPatient() {
        log.info("Enter name: ");
        String name = scanner.nextLine();

        log.info("Enter age: ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                try {
                    if (age < 1) {
                        throw new AgeEnterException();
                    }
                }
                catch (AgeEnterException e)  {
                    log.error(e.getMessage());
                    log.info("Try one more time");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                log.error(e.getMessage());
                log.info("Try one more time");
            }
        }

        log.info("Enter gender: ");
        String gender = scanner.nextLine();

        return new Patient(name, age, gender);
    }
    private boolean patientLimit(int size) {
        return size > 10;
    }
}
