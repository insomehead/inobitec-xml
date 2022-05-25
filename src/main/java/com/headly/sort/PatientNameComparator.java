package com.headly.sort;

import com.headly.model.Patient;

public class PatientNameComparator implements PatientComparator {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        return patient1.getLastName().compareTo(patient2.getLastName());
    }
}
