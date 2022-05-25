package com.headly;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.headly.model.Patient;
import com.headly.sort.PatientAgeComparator;
import com.headly.sort.PatientNameComparator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Ошибка. Нет параметров");
            System.exit(0);
        }
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JSR310Module());
        List<Patient> patients = new ArrayList<>();
        File file;
        String sortArg = "";
        for (String arg : args) {
            file = new File(arg);
            if (arg.endsWith(".xml") & file.exists()) {
                patients.addAll(xmlMapper.readValue(file, new TypeReference<>() {
                }));
            } else {
                sortArg = arg;
            }
        }
        if (patients.isEmpty()){
            System.out.println("Ошибка. Файл не введен");
            System.exit(0);
        }
        switch (sortArg) {
            case "age" -> patients.sort(new PatientAgeComparator());
            case "name" -> patients.sort(new PatientNameComparator());
        }

        Patient.printTableForPatients(patients);
    }
}