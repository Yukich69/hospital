package com.solvd.hospital;


import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.people.Patient;
import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Hospital;
import com.solvd.hospital.structure.HospitalCreation;
import com.solvd.hospital.structure.Office;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;


public class Main {

        public static void main(String[] args) {
                List<Doctor> surgeryDoctors = new ArrayList<>(){
                        {
                                add(new Doctor(new Office(1), "Jon", 42));
                                add(new Doctor(new Office(2), "Jack", 39));
                        }
                };

                 List<Doctor> cardiologyDoctors = new ArrayList<>(){
                         {
                                add(new Doctor(new Office(3), "Ben", 41));
                                add(new Doctor(new Office(4), "Fill", 45));
                        }
                };

                List<Nurse> surgeryNurses = new ArrayList<>(){
                        {
                                add(new Nurse( "Hellen", 32));
                                add(new Nurse("Jane", 30));
                        }
                };

                 List<Nurse> cardiologyNurses = new ArrayList<>(){
                        {
                                add(new Nurse("Emma", 37));
                                add(new Nurse("Lis", 35));
                        }
                };

                 LinkedHashSet<Department> departmentList = new LinkedHashSet<>(){
                        {
                                add(new Department("Surgery", surgeryDoctors, surgeryNurses));
                                add(new Department("Cardiology", cardiologyDoctors, cardiologyNurses));
                        }
                };


                 Hospital hospital = new Hospital("Hope", "Kyiv", departmentList );
                ArrayList<Patient> patients = new ArrayList<>();
                Doctor a = surgeryDoctors.get(0);
                patients.add(a.addPatient());
                a.setPatientList(patients);
                hospital.toString();
        }

}
