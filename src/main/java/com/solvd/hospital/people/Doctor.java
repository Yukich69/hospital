package com.solvd.hospital.people;

import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.DiseaseType;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Office;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Doctor extends Employee {
    private static final Logger log = LogManager.getLogger(Doctor.class);
    private static final Scanner scanner = new Scanner(System.in);
    private List<Patient>  patientList;
    private Office office;
    private String name;


    public Doctor(){
    }

    public Doctor(String name, double salary){
        this.name = name;
    }

    public Doctor(Office office, String name){
        this.office = office;
        this.name = name;
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

    public void setPatientList(ArrayList<Patient> patients){this.patientList = patients;}

    public void addToList(Patient patient){
        this.patientList.add(patient);
    }

    @Override
    public String getName() {
        return name;
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
        log.info("Enter your disease: cardio(1) or surg(2) ");
        String disease = "";
        if(scanner.nextLine().equals("1")) {
             disease = "heart disease";
        }else if(scanner.nextLine().equals("2")){
            disease = "tumor";
        }
        LinkedHashSet<Disease> disset = new LinkedHashSet<>();
        Disease dis = new Disease();
        dis.setDisease(disease);
        HealthCard card = new HealthCard();
        switch (disease) {
            case "heart disease":
                dis.setType(DiseaseType.CARDIO);
                break;
            case "tumor":
                dis.setType(DiseaseType.SURGERY);
                break;
            default:
                log.info("Are you sure?");
                break;
        }
        disset.add(dis);
        card.setDiseaseList(disset);
        Patient patient = new Patient(name, age, gender, card);
        addToList(patient);
        return patient;
    }
    private boolean patientLimit(int size) {
        return size > 10;
    }
}
