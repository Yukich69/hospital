package com.solvd.hospital.people;


public class AgeEnterException extends Exception{

    public AgeEnterException() {
        super("Wrong age entered");
    }

    public AgeEnterException(String str) {
            super(str);
        }


}
