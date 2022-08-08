package com.solvd.hospital.people;

import com.solvd.hospital.structure.Department;

import java.util.Objects;

public abstract class Employee extends Person implements Workable {
    private Department department;
    private double salary;
    private boolean hasEducation;

    public Employee(){
    }

    public Employee(Department department, double salary){
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, boolean hasEducation, int age, Department department, double salary){
        super(name, age);
        this.department = department;
        this.salary = salary;
        this.hasEducation = hasEducation;
    }

    public Department getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",department=" + getDepartment().toString()
                +  ",salary=" + getSalary() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getDepartment().hashCode(), getSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return hashCode() == employee.hashCode();
    }

    @Override
    public boolean isWorkable() {
        return hasEducation && getAge() < 60;
    }
}
