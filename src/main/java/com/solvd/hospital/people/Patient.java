package com.solvd.hospital.people;

import java.util.Objects;

public class Patient  extends Person {
    private String gender;


    public Patient() {
    }

    public Patient (String name,int age,String gender) {
        super(name, age);
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }


    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",gender=" + getGender() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getGender().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return hashCode() == patient.hashCode();
    }



}
