package com.solvd.hospital.structure;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Hospital implements DepartmentSettable {
    private String name;
    private String city;
    private LinkedHashSet<Department> departmentList;

    public Hospital() {
    }

    public Hospital(String name, String city, LinkedHashSet<Department> departmentList){
        this.name = name;
        this.city = city;
        this.departmentList = departmentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashSet<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(LinkedHashSet<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",departments=" + getDepartmentList().toString()
                +  ",city=" + getCity()  + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getCity().hashCode(), getDepartmentList().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return hashCode() == hospital.hashCode();
    }

    @Override
    public Department addDepartment(String name, List<Doctor> doctorList, List<Nurse> nurseList) {
        Department department = new Department(name, doctorList, nurseList);
        departmentList.add(department);
        return department;
    }

    @Override
    public LinkedHashSet<Department> deleteDepartment(Department department)  {
        departmentList.remove(department);
        return departmentList;
    }
}
