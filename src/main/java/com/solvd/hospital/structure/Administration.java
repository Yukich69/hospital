package com.solvd.hospital.structure;

import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Employee;
import com.solvd.hospital.people.Patient;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Administration implements CardSettable {

    private LinkedHashSet<HealthCard> healthCards;
    private Employee employee;

    public Administration() {
    }

    public LinkedHashSet<HealthCard> getHealthCardList() {
        return healthCards;
    }

    public void setHealthCardList(LinkedHashSet<HealthCard> healthCards) {
        this.healthCards = healthCards;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

    }

    @Override
    public String toString() {
        return getClass().getName() + "[healthCardList=" + getHealthCardList().toString() +  ",employee=" + getEmployee().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealthCardList().hashCode(), getEmployee().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administration administration = (Administration) o;
        return hashCode() == administration.hashCode();
    }

    @Override
    public HealthCard addHealthCard(String cardId, Patient patient, LinkedHashSet<Disease> diseaseList) {
        HealthCard card = new HealthCard(cardId, diseaseList);
        healthCards.add(card);
        return card;
    }

    @Override
    public LinkedHashSet<HealthCard> deleteHealthCard(HealthCard card) {
        healthCards.remove(card);
        return healthCards;
    }


}
