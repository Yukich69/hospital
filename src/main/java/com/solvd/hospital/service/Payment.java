package com.solvd.hospital.service;

import com.solvd.hospital.people.Patient;

import java.util.List;
import java.util.Objects;

public class Payment implements Payable {
    private double price;
    private List<Service> serviceList;
    private Patient patient;

    public Payment(){
    }

    public Payment(double price, List<Service> serviceList, Patient patient){
        this.price = price;
        this.serviceList = serviceList;
    }

    public double getPrice() {
        return price;
    }
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[price=" + getPrice() + ",services=" + getServiceList().toString() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getServiceList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return hashCode() == payment.hashCode();
    }

    @Override
    public void increasePayment(double price) {
        this.price += price;
    }
}
