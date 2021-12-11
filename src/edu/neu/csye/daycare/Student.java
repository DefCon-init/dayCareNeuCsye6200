package edu.neu.csye.daycare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Person {
    /*
     * Basic Student class to encapsulate all the student information
     */

    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private Date registrationDate;
    private int age;
    private List<Date> immunisationDates = new ArrayList<>();
    private String address;
    private String phoneNumber;
    private String parentName;
    private String email;
    private Date annualRegistrationDate;

    public Student() {
        super();
    }

    public Student(int id, Date registrationDate, String address, String phoneNumber, String parentName,
                   String parentsEmail) {
        super();
        this.id = id;
        this.registrationDate = registrationDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = FileUtil.DobToAge(this.dob);
        this.parentName = parentName;
        this.email = email;

        Calendar c = Calendar.getInstance();
        c.setTime(this.registrationDate);
        c.add(c.YEAR, 1);
        this.annualRegistrationDate = c.getTime();

    }

    public Student(String csvData) {
        super();
        String[] tokens = csvData.split(",");
        this.firstName = tokens[0];
        this.lastName = tokens[1];
        try {
            this.id = Integer.valueOf(tokens[3]);
            this.dob = new SimpleDateFormat("dd/mm/yyyy").parse(tokens[2]);
            this.registrationDate = new SimpleDateFormat("dd/mm/yyyy").parse(tokens[4]);
        } catch (ParseException e) {
            System.out.println("INVALID TYPE");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("INVALID TYPE");
            e.printStackTrace();
        }
        this.address = tokens[5];
        this.phoneNumber = tokens[6];
        this.parentName = tokens[7];
        this.email = tokens[8];
        this.age = FileUtil.DobToAge(this.dob);
        Calendar c = Calendar.getInstance();
        c.setTime(this.registrationDate);
        c.add(c.YEAR, 1);
        this.annualRegistrationDate = c.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentName() {
        return parentName;
    }

    public void setparentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Date> getImmunisationDates() {
        return immunisationDates;
    }

    public void setImmunisationDates(List<Date> immunisationDates) {
        this.immunisationDates = immunisationDates;
    }

    public Date getAnnualRegistrationDate() {
        return annualRegistrationDate;
    }

    public void setAnnualRegistrationDate(Date annualRegistrationDate) {
        this.annualRegistrationDate = annualRegistrationDate;
    }

    @Override
    public String toString() {
        return "Student { " + "id = " + id + ", age = " + age + ", name = " + firstName + " " + lastName
                + ", registrationDate = " + registrationDate + ", address = " + address + ", phoneNumber = "
                + phoneNumber + " }";
    }

}
