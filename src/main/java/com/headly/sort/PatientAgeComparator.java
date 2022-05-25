package com.headly.sort;

import com.headly.model.Patient;

public class PatientAgeComparator implements PatientComparator {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        return patient1.getBirthday().compareTo(patient2.getBirthday());
    }
}
