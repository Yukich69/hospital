package com.solvd.hospital.healthInfo;

import com.solvd.hospital.people.Patient;

import java.util.LinkedHashSet;
import java.util.Objects;

public class HealthCard implements DiseaseSettable{
    private String cardId;
    private LinkedHashSet<Disease> diseaseList;
    private Patient patient;

    public HealthCard() {
    }

    public HealthCard(String cardId, Patient patient, LinkedHashSet<Disease> diseaseList) {
        this.cardId = cardId;
        this.patient = patient;
        this.diseaseList = diseaseList;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LinkedHashSet<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(LinkedHashSet<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + getCardId() + ",patient=" + getPatient().toString()
                +  ",office=" + getDiseaseList().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId().hashCode(), getPatient().hashCode(), getDiseaseList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCard card = (HealthCard) o;
        return hashCode() == card.hashCode();
    }

    @Override
    public Disease addDisease(String name) {
        Disease disease = new Disease(name);
        diseaseList.add(disease);
        return disease;
    }

    @Override
    public LinkedHashSet<Disease> deleteDisease(Disease disease) throws NullPointerException {
        diseaseList.remove(disease);
        return diseaseList;
    }
}
