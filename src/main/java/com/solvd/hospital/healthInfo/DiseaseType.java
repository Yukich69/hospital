package com.solvd.hospital.healthInfo;

public enum DiseaseType {

    CARDIO("cardio"),
    SURGERY("surg");

    private String disease;

    DiseaseType(){
    }

    DiseaseType(String disease) {
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
        return "DiseaseType{" +
                "disease='" + disease + '\'' + '}';
    }
}
