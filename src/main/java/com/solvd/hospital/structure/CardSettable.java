package com.solvd.hospital.structure;

import com.solvd.hospital.healthInfo.Disease;
import com.solvd.hospital.healthInfo.HealthCard;
import com.solvd.hospital.people.Patient;
import java.util.LinkedHashSet;

public interface CardSettable {

      HealthCard addHealthCard(String cardId, Patient patient, LinkedHashSet<Disease> diseaseList);

      LinkedHashSet<HealthCard> deleteHealthCard(HealthCard card);

}
