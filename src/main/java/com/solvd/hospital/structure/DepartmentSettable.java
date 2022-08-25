package com.solvd.hospital.structure;

import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Nurse;

import java.util.LinkedHashSet;
import java.util.List;

public interface DepartmentSettable {

    Department addDepartment(String name, List<Doctor> doctorList, List<Nurse> nurseList);

   // LinkedHashSet<Department> deleteDepartment(Department department);

}
