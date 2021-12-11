package edu.neu.csye.daycare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AddRatio {

    static int currentTeacher = 0;
    static String studentfile = "C:\\Users\\Public\\students.csv";
    static String teachersfile = "C:\\Users\\Public\\teachers.csv";
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();

    public static void CreateGroup() throws IOException {

        List<String> S1 = FileUtil.readCsv(studentfile);
        S1.forEach(student -> students.add(new Student(student)));

        List<String> T1 = FileUtil.readCsv(teachersfile);
        T1.forEach(teacher -> teachers.add(new Teacher(teacher)));

        List<Student> Group1= new ArrayList<>();
        List<Student> Group2= new ArrayList<>();
        List<Student> Group3= new ArrayList<>();
        List<Student> Group4= new ArrayList<>();
        List<Student> Group5= new ArrayList<>();
        List<Student> Group6= new ArrayList<>();
        for(Student i:students){
            if(i.getAge() >= 6 && i.getAge() <= 12);{
                Group1.add(i);}
            if(i.getAge() >= 13 && i.getAge() <= 24);{
                Group2.add(i);}
            if(i.getAge() >= 25 && i.getAge() <= 35);{
                Group3.add(i);}
            if(i.getAge() >= 36 && i.getAge() <= 47);{
                Group4.add(i);}
            if(i.getAge() >= 48 && i.getAge() <= 59);{
                Group5.add(i);}
            if(i.getAge() >= 60 );{
                Group6.add(i);}}

        List<List<Student>> studentAgeGroups = new ArrayList<>();

        studentAgeGroups.add(Group1);
        studentAgeGroups.add(Group2);
        studentAgeGroups.add(Group3);
        studentAgeGroups.add(Group4);
        studentAgeGroups.add(Group5);
        studentAgeGroups.add(Group6);

        for(List<Student> i : studentAgeGroups) {
            System.out.println(i);
        }



        for(int i=0;i < studentAgeGroups.size();i++) {

            switch(i){
                case 0:
                {System.out.println("calling 0");
                    AddStudentGroup(studentAgeGroups.get(i), 4, 3);
                    break;}
                case 1:
                {System.out.println("calling 1");
                    AddStudentGroup(studentAgeGroups.get(i), 5, 3);
                    break;}
                case 2:
                {System.out.println("calling 2");
                    AddStudentGroup(studentAgeGroups.get(i), 6, 3);
                    break;}
                case 3:
                {System.out.println("calling 2");
                    AddStudentGroup(studentAgeGroups.get(i), 8, 3);
                    break;}
                case 4:
                {System.out.println("calling 2");
                    AddStudentGroup(studentAgeGroups.get(i), 12, 2);
                    break;}
                case 5:
                {System.out.println("calling 2");
                    AddStudentGroup(studentAgeGroups.get(i), 15, 2);
                    break;}
            }
        }

        AddTeacher(teachers, Daycare.getClassroom());

    }

    public static void AddStudentGroup(List<Student> StudentGroup, int GroupSize, int MaximumClass) {
        //System.out.println("Inside AddStudent");
        System.out.println(StudentGroup);
        System.out.println(GroupSize);
        int TotalGroups = 0;
        if(StudentGroup.size()%GroupSize == 0) {
            TotalGroups = StudentGroup.size()/GroupSize;	}
        else {
            TotalGroups = StudentGroup.size()/GroupSize + 1;}
        List<Classroom> classrooms = new ArrayList<>();
        int i,j,gs=0;
        for(i = 0; i < TotalGroups; i++) {
            classrooms.add(ClassroomFactory.getInstance().getObject());
            for(j = 0; j < GroupSize; j++) {
                if((gs+j)<StudentGroup.size()) {
                    classrooms.get(i).addStudents(StudentGroup.get(gs+j));
                }
            }
            gs = gs + GroupSize;
        }

        List<Classroom> C1 = new ArrayList<>();
        int tempC = 0,numClassrooms = 0;
        if(classrooms.size()%MaximumClass == 0) {
            numClassrooms = classrooms.size()/MaximumClass;

        } else {
            numClassrooms = classrooms.size()/MaximumClass + 1;
        }

        System.out.println("number of classrooms");
        System.out.println(classrooms.size());
        System.out.println(numClassrooms);
        for(int i1 = 0; i1<numClassrooms; i1++) {
            C1.add(ClassroomFactory.getInstance().getObject());
            for(int j1 = 0; j1 < MaximumClass; j1++) {
                if((tempC+j1) < classrooms.size()) {
                    C1.get(i1).addClassroom(classrooms.get(tempC + j1));
                }
            }

            tempC = tempC + MaximumClass;
        }

        for(Classroom c:C1){
            Daycare.addClassroom(c);}
    }


    public static void AddTeacher(List<Teacher> t, List<Classroom> c) {
        int count = 0;
        for(Classroom cl : c) {
            for(Classroom g : cl.getClassroom()) {
                g.setTeacher(t.get(count));
                //System.out.println("Inside AddTeacher");
                System.out.println(g);
                System.out.println(t.get(count));
                count = count + 1;
                if(count == t.size()) {
                    count = 0;
                }
            }
        }

    }

}