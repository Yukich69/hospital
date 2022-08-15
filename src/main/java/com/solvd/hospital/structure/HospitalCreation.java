package com.solvd.hospital.structure;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;

import java.util.*;

public class HospitalCreation {

    private static  List<Doctor> surgeryDoctors = new ArrayList<>(){
        {
           add(new Doctor());
           add(new Doctor());
           add(new Doctor());
           add(new Doctor());
        }
    };

    private static  List<Doctor> cardiologyDoctors = new ArrayList<>(){
        {
            add(new Doctor());
            add(new Doctor());
            add(new Doctor());
            add(new Doctor());
        }
    };

    private static List<Nurse> surgeryNurses = new ArrayList<>(){
        {
            add(new Nurse());
            add(new Nurse());
            add(new Nurse());
            add(new Nurse());
        }
    };

    private static List<Nurse> cardiologyNurses = new ArrayList<>(){
        {
            add(new Nurse());
            add(new Nurse());
            add(new Nurse());
            add(new Nurse());
        }
    };

    private static LinkedHashSet<Department> departmentList = new LinkedHashSet<>(){
        {
            add(new Department("Surgery", surgeryDoctors, surgeryNurses));
            add(new Department("Cardiology", cardiologyDoctors, cardiologyNurses));
        }
    };

    private List<Office> offices;

    private static final Hospital hospital = new Hospital("Hope", "Kyiv", departmentList );
}

