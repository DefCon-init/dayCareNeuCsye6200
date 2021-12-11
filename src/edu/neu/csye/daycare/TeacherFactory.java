package edu.neu.csye.daycare;

public class TeacherFactory extends PersonFactory {

    private static TeacherFactory instance;

    private TeacherFactory() {
        instance = null;
    }

    public static TeacherFactory getInstance() {
        if(instance == null) {
            instance = new TeacherFactory();
        }
        return instance;
    }

    @Override
    public Person getObject() {
        return new Teacher();
    }

    @Override
    public Person getObject(String csvData) {
        return new Teacher(csvData);
    }

}
