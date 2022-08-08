package com.solvd.hospital.healthInfo;

import java.util.LinkedHashSet;

public interface DiseaseSettable {

    Disease addDisease(String disease);

    LinkedHashSet<Disease> deleteDisease(Disease disease);

}
