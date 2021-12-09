package edu.neu.csye.daycare;

import java.util.List;
import java.util.Vector;

public class Classroom {
/*
    Classroom Class to store information regarding students and teachers and other ratios
 */

    private int capacity;
    private static List<Person> teachers = new Vector<>();
    private static List<Person> students = new Vector<>();

    public static List<Person> getTeachers() {
        return teachers;
    }

    public static List<Person> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
