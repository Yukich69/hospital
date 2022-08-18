package com.solvd.hospital.healthInfo;

import java.util.LinkedHashSet;

public interface DiseaseSettable {


    Disease addDisease(String name, DiseaseType type);

    LinkedHashSet<Disease> deleteDisease(Disease disease);

}
