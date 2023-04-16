package homework.Std;

public class StudentService {
    public String Format(Student student){
        return student.getStudentId() + " " + student.getStudentName();
    }

    public Student Parse(String line){
        String[] newLine = line.split(" ");
        return new Student(Integer.parseInt(newLine[0]), newLine[1]);
    }
}
