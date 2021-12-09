package edu.neu.csye.daycare;

import java.util.List;

public class ObjectFactory {
/*
    Class to perform factory design
 */

    public void getInstance(List<String> list) {
        list.stream().forEach(str -> {
            String objType = differentiate(str);
            if (objType == "Teacher") {
                list.stream().forEach(p -> {
                    Classroom.getTeachers().add(new Teacher(p));
                });
            }
            else {
                list.stream().forEach(p -> {
                    Classroom.getStudents().add(new Student(p));
                });
            }
        });
    }

    public String differentiate(String str) {
        String type;
        String[] arr = str.split(",");
        if(arr.length == 3) {
            type = "Teacher";
        } else {
            type = "Student";
        }
        return type;
    }

}
