package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class HepatitisB extends Immunization {

    HepatitisB(String name, List<Date> immunizationDates, int age) {
        this.immunizationName = name;
        this.immunizationDates= immunizationDates;
        this.age = age;
    }

    @Override
    public void checkImmunization(Student s) {
        EmailNotification m = new EmailNotification(s.getEmail());
        if(immunizationDates.size() < 3) {
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
        if(immunizationDates.size() < 3) {
            return "Hepatitis B vaccination is due";
        }
        return "Hepatitis B vaccination is already done";
    }

}
