package com.solvd.hospital.structure;

import java.util.Objects;

public class Office {
    private int officeNum;

    public Office(){
    }

    public Office(int officeNum){
        this.officeNum = officeNum;
    }

    public int getOffice(){
        return officeNum;
    }

    public void setOffice(int officeNum){
        this.officeNum = officeNum;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[office=" + getOffice() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return hashCode() == office.hashCode();
    }

}
