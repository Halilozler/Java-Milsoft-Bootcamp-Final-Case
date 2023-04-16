package homeworks.education;

import java.util.ArrayList;

public class Test {
    /*
    HW 1B:
    com.godoro.education
        School
        Classroom
        Student +averageMark
        Test
            901 Godoro Üniversitesi
                701 Mühendislik
                    301 "Neşet Ertaş"  45.2
                    303 "Mahsuni Şerif" 36.5
                    304 "Celal Güzelses" 61.2
                702 Ekonomi
                    302 "Erkan Ocaklı" 71.3
                    305 "Mustafa Topaloğlu" 42.2
     */
    public static void main(String[] args) {
        School school1 = new School(901, "Godoro Üniversitesi");
        Classroom classroom1 = new Classroom(701, "Mühendislik");
        Classroom classroom2 = new Classroom(702, "Ekonomi");
        Student student1 = new Student(301, "Neşet Ertaş", 45.2);
        Student student2 = new Student(302, "Erkan Ocaklı", 71.3);
        Student student3 = new Student(303, "Mahsuni Şerif", 36.5);
        Student student4 = new Student(304, "Celal Güzelses", 61.2);
        Student student5 = new Student(305, "Mustafa Topaloğlu", 42.2);

        student1.setClassroom(classroom1);
        student2.setClassroom(classroom2);
        student3.setClassroom(classroom1);
        student4.setClassroom(classroom1);
        student5.setClassroom(classroom2);

        school1.setClassroomList(new ArrayList<Classroom>());
        classroom1.setStudentList(new ArrayList<Student>());
        classroom2.setStudentList(new ArrayList<Student>());

        school1.getClassroomList().add(classroom1);
        school1.getClassroomList().add(classroom2);

        classroom1.setSchool(school1);
        classroom2.setSchool(school1);

        classroom1.getStudentList().add(student1);
        classroom1.getStudentList().add(student3);
        classroom1.getStudentList().add(student4);

        classroom2.getStudentList().add(student2);
        classroom2.getStudentList().add(student5);

        System.out.println(school1.getSchoolId() + " " + school1.getSchoolName());
        for(Classroom classroom : school1.getClassroomList()){
            System.out.println("\t" + classroom.getClassroomId() + " " + classroom.getClassroomName());
            for(Student student : classroom.getStudentList()){
                System.out.println("\t" + "\t" + student.getStudentId() + " " + student.getStudentName() + " " + student.getAverageMark());
            }
        }
    }
}
