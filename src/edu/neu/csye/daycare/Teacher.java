package edu.neu.csye.daycare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Teacher extends Person {
/*
    Basic Teacher Class to store all the teacher information
 */

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Date joiningDate;
    private String email;
    private Date annualReviewDate;

    public Teacher() {
        super();
    }

    public Teacher(int id, Date joiningDate) {
        super();
        this.id = id;
        this.joiningDate = joiningDate;
        Calendar c = Calendar.getInstance();
        c.setTime(this.joiningDate);
        c.add(c.YEAR, 1);
        this.annualReviewDate = c.getTime();
    }

    public Teacher(String csvData) {
        super();
        String[] tokens = csvData.split(",");
        this.firstName  = tokens[0];
        this.lastName  = tokens[1];
        try {
            this.age = Integer.valueOf(tokens[2]);
            this.id = Integer.valueOf(tokens[3]);
            this.joiningDate = new SimpleDateFormat("dd/mm/yyyy").parse(tokens[4]);
        } catch (ParseException e) {
            System.out.println("INVALID TYPE");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("INVALID TYPE");
            e.printStackTrace();
        }
        this.email = tokens[5];
        Calendar c = Calendar.getInstance();
        c.setTime(this.joiningDate);
        c.add(c.YEAR, 1);
        this.annualReviewDate = c.getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAnnualReviewDate() {
        return annualReviewDate;
    }

    public void setAnnualReviewDate(Date annualReviewDate) {
        this.annualReviewDate = annualReviewDate;
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
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Teacher { " +
                " id = " + id +
                " age = " + age +
                ", name = " + firstName + " " + lastName +
                ", joining date = " + joiningDate + "}";
    }

}
