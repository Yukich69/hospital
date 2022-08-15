package com.solvd.hospital;


import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.structure.HospitalCreation;


public class Main {

        public static void main(String[] args) {
                HospitalCreation hc = new HospitalCreation();
                Doctor a = new Doctor();
                a.setName("Gon");
                a.setAge(43);
                a.addPatient();
        }

}
