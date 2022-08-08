package com.solvd.hospital.healthInfo;

import java.util.Objects;

public class Disease {
    private String disease;

    public Disease(){
    }

    public Disease(String disease){
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getDisease() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDisease().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return hashCode() == disease.hashCode();
    }
}
