package com.solvd.hospital.people;

import com.solvd.hospital.service.Consultation;
import com.solvd.hospital.structure.Department;

import java.util.List;

public class Nurse extends Employee {
    private List<Consultation> consultationList;

    public Nurse(){
    }

    public Nurse(String name, int age){

    }

    public Nurse(Department department, double salary, String name, boolean hasEducation, int age,
                 List<Consultation> consultationList) {
        super(name, hasEducation, age, department, salary);
        this.consultationList = consultationList;
    }

    public static Functional<Nurse, Doctor> hired = x -> new Doctor(x.getName(), x.getSalary());
    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

   // @Override
   //public String toString() {
      //  return getClass().getName() + "[name=" + getName() + ",departments=" + getDepartment().toString()
       //        +  ",salary=" + getSalary()  + "]";
   // }

   //@Override
   // public int hashCode() {
     //   return Objects.hash(getName().hashCode(), getDepartment().hashCode(), getSalary());
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return hashCode() == nurse.hashCode();
    }
}
