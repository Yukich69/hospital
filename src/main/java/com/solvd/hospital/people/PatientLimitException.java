package com.solvd.hospital.people;

public class PatientLimitException extends RuntimeException {

    public PatientLimitException() {
        super("A lot of patient");
    }

    public PatientLimitException(String str) {
        super(str);
    }

}
