package edu.neu.csye.daycare;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classroom {
    /*
        Classroom Class to store information regarding students and teachers and other ratios
     */
    private static int classID = 0;
    private int id = 0;
    private int capacity;
    private static List<Person> teachers = new ArrayList<>();
    private static List<Person> students = new ArrayList<>();
    private Teacher teacher;
    private List<Classroom> classroom = new ArrayList<>();

    public Classroom() {
        classID++;
        id = classID;
    }

    public void addStudents(Student s) {
        students.add(s);
    }

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

    public void setTeacher(Teacher t) {
        this.teacher = t;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public int getId() {
        return id;
    }

    public void addClassroom(Classroom c) {
        classroom.add(c);
    }

    public List<Classroom> getClassroom() {
        return this.classroom;
    }

}
