package edu.neu.csye.daycare;

public class Teacher extends Person {
/*
    Basic Teacher Class to store all the teacher information
 */

    private int age;
    private String name;
    private int credits;

    public Teacher() {}

    public Teacher(String csv) {
        String[] arr = csv.split(",");
        this.setAge(Integer.parseInt(arr[0]));
        this.setName(arr[1]);
    }

    public Teacher(int credits, int age, String name) {
        this.setName(name);
        this.setAge(age);
        this.setCredits(credits);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }

}
