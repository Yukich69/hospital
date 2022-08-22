package com.solvd.hospital;


import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.info.InfoSetup;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.people.Patient;
import com.solvd.hospital.structure.Department;
import com.solvd.hospital.structure.Hospital;
import com.solvd.hospital.structure.HospitalCreation;
import com.solvd.hospital.structure.Office;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;


public class Main {

        public static void main(String[] args) {
            InfoSetup is = new InfoSetup();
            is.info(new File("HOSP_INFO.txt"));
            is.start();
        }

}
