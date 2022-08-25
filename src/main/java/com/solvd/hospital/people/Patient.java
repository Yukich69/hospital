package com.solvd.hospital.people;

import com.solvd.hospital.healthInfo.HealthCard;

import java.util.Objects;

public class Patient  extends Person {
    private String gender;
    private HealthCard card;

    private String name;

    public Patient() {
    }

    public Patient(String name) {
        this.name = name;
    }

    public Patient (String name,int age,String gender, HealthCard card) {
        super(name, age);
        this.gender = gender;
        this.card = card;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setCard(HealthCard card){this.card = card;}

    public HealthCard getCard() {
        return card;
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
