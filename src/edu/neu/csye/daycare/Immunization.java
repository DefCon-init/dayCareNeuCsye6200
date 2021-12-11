/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye.daycare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public  abstract class Immunization {
    String immunizationName;
    List<Date> immunizationDates = new ArrayList<>();
    int age;
    public abstract void checkImmunization(Student s);
    public abstract String showImmunization(Student s);
}
