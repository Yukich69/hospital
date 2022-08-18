package com.solvd.hospital.structure;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;

import java.util.*;

public class HospitalCreation {

    public static  List<Doctor> surgeryDoctors = new ArrayList<>(){
        {
           add(new Doctor(new Office(1), "Jon", 42));
           add(new Doctor(new Office(2), "Jack", 39));
        }
    };

    public static  List<Doctor> cardiologyDoctors = new ArrayList<>(){
        {
            add(new Doctor(new Office(3), "Ben", 41));
            add(new Doctor(new Office(4), "Fill", 45));
        }
    };

    public static List<Nurse> surgeryNurses = new ArrayList<>(){
        {
            add(new Nurse( "Hellen", 32));
            add(new Nurse("Jane", 30));
        }
    };

    public static List<Nurse> cardiologyNurses = new ArrayList<>(){
        {
            add(new Nurse("Emma", 37));
            add(new Nurse("Lis", 35));
        }
    };

    public static LinkedHashSet<Department> departmentList = new LinkedHashSet<>(){
        {
            add(new Department("Surgery", surgeryDoctors, surgeryNurses));
            add(new Department("Cardiology", cardiologyDoctors, cardiologyNurses));
        }
    };

    public List<Office> offices;

    public static  Hospital hospital = new Hospital("Hope", "Kyiv", departmentList );
}

