package edu.neu.csye.daycare;

public class StudentFactory extends PersonFactory{

    private static StudentFactory instance;

    private StudentFactory() {
        instance = null;
    }

    public static StudentFactory getInstance() {
        if(instance == null) {
            instance = new StudentFactory();
        }
        return instance;
    }

    @Override
    public Person getObject(String csvData) {
        return new Student(csvData);
    }

    @Override
    public Person getObject() {
        // TODO Auto-generated method stub
        return null;
    }

}
