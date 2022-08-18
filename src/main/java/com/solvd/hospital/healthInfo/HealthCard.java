package com.solvd.hospital.healthInfo;

import com.solvd.hospital.people.Patient;

import java.util.LinkedHashSet;
import java.util.Objects;

public class HealthCard implements DiseaseSettable{
    private String cardId;
    private LinkedHashSet<Disease> diseaseList;

    public HealthCard() {
    }

    public HealthCard(String cardId, LinkedHashSet<Disease> diseaseList) {
        this.cardId = cardId;
        this.diseaseList = diseaseList;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


    public LinkedHashSet<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(LinkedHashSet<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + getCardId() + ",patient="
                +  ",office=" + getDiseaseList().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId().hashCode(), getDiseaseList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCard card = (HealthCard) o;
        return hashCode() == card.hashCode();
    }

    @Override
    public Disease addDisease(String name, DiseaseType type) {
        Disease disease = new Disease(name,type);
        diseaseList.add(disease);
        return disease;
    }

    @Override
    public LinkedHashSet<Disease> deleteDisease(Disease disease) throws NullPointerException {
        diseaseList.remove(disease);
        return diseaseList;
    }
}
