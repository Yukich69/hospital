package com.solvd.hospital.info;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Employee;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.people.Patient;
import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Office;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfoSetup {

    private static final Logger log = LogManager.getLogger(InfoSetup.class);

    public void info(File file) {
        String text;
        try {
            text = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String word = "care";
            log.info("Word: " + word + ", Num: " + StringUtils.countMatches(text, word));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
       // Doctor d = new Doctor(new Office(1), "Jon", 42);
        //Doctor c = new Doctor(new Office(2), "Jack", 39);
       // List<Doctor> surgeryDoctor = Stream.of(d, c)
           //     .collect(Collectors.toCollection(() -> new ArrayList<Doctor>()));
        Nurse m = new Nurse("Sally", 43);
        Doctor hired = Nurse.hired.hire(m);

        List<Doctor> surgeryDoctors = new ArrayList<>(){
            {
                add(hired);
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


        //Hospital hospital = new Hospital("Hope", "Kyiv", departmentList );
        ArrayList<Patient> patients = new ArrayList<>();
        Doctor a = surgeryDoctors.get(0);
        patients.add(a.addPatient());
        a.setPatientList(patients);
        //hospital.toString();
    }
}
