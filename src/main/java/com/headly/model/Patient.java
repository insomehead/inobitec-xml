package com.headly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Data
public class Patient {

    @JacksonXmlProperty(localName = "first_name")
    private String firstName;

    @JacksonXmlProperty(localName = "middle_name")
    private String middleName;

    @JacksonXmlProperty(localName = "last_name")
    private String lastName;

    @JacksonXmlProperty(localName = "gender")
    private String gender;

    @JacksonXmlProperty(localName = "birthday")
    private LocalDate birthday;

    @JacksonXmlProperty(localName = "phone")
    private String phone;

    public String getGender() {
        if (this.gender.equals("male")) {
            return "М";
        }
        return "Ж";
    }

    public int getAge() {
        return (int) YEARS.between(birthday, LocalDate.now());
    }

    public static void printTableForPatients(List<Patient> patients) {
        System.out.println(String.format("+%-48s+%-8s+%-4s+%-15s+",
                " ", " ", " ", " ").replace(' ', '-'));
        System.out.format("|%-48s|%-8s|%-4s|%-15s| \n",
                "ФИО", "Возраст", "Пол", "Телефон");
        System.out.println(String.format("+%-48s+%-8s+%-4s+%-15s+",
                " ", " ", " ", " ").replace(' ', '-'));
        patients.forEach(patient -> System.out.format("|%-15s %-15s %-15s |%-8s|%-4s|%-15s|\n",
                patient.getLastName(),
                patient.getFirstName(),
                patient.getMiddleName(),
                patient.getAge(),
                patient.getGender(),
                patient.getPhone()));
        System.out.println(String.format("+%-48s+%-8s+%-4s+%-15s+",
                " ", " ", " ", " ").replace(' ', '-'));
    }
}