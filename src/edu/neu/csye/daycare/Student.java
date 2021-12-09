package edu.neu.csye.daycare;

public class Student extends Person {
/*
    Basic Student class to encapsulate all the student information
 */

    private int id;
    private double gpa;
    private int age;
    private String name;

    public Student() {}

    public Student(String csv) {
        String[] arr = csv.split(",");
        this.setId(Integer.parseInt(arr[0]));
        this.setAge(Integer.parseInt(arr[1]));
        this.setName(arr[2]);
    }

    public Student(int age, String name, double gpa, int id) {
        this.setAge(age);
        this.setGpa(gpa);
        this.setName(name);
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
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
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
