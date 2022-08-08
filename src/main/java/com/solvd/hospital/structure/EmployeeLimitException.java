package com.solvd.hospital.structure;

public class EmployeeLimitException extends RuntimeException {

    public EmployeeLimitException() {
        super("Department is full");
    }

    public EmployeeLimitException(String str) {
        super(str);
    }
}
