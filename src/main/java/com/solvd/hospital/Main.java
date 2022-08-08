package com.solvd.hospital;


import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Doctor;

public class Main {

        public static void main(String[] args) {
                Doctor a = new Doctor();
                a.setName("Gon");
                a.setAge(43);
                a.addPatient();
        }

}
