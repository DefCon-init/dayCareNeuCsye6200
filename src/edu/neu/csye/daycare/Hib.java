package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class Hib extends Immunization {

    Hib(String name, List<Date> immunizationDates, int age) {
        this.immunizationName = name;
        this.immunizationDates= immunizationDates;
        this.age = age;
    }

    @Override
    public void checkImmunization(Student s) {
        EmailNotification m = new EmailNotification(s.getEmail());
        if(immunizationDates.size() < 4) {
            System.out.println(s.getAge());
            m.setVaccine(this.immunizationName);
            m.setStudentName(s.getFirstName() + " " + s.getLastName());
            m.setReceipient(s.getParentName());
            m.setPhoneNumber(s.getPhoneNumber());
            m.sendImmunizationNotification();
        }
    }

    @Override
    public String showImmunization(Student s) {
        if(immunizationDates.size() < 4) {
            return "Hib vaccination is due";
        }
        return "Hib vaccination is already done";
    }

}
