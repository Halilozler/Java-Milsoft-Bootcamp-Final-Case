package homework.Std;

import java.nio.file.Paths;
import java.util.List;

public class TestLoad {
    public static void main(String[] args) {
        try{
            String path = Paths.get("").toAbsolutePath().toString() + "/text.txt";;
            StudentFiler filer = new StudentFiler(path);
            List<Student> students = filer.Load();
            for(Student student : students){
                System.out.println(student.getStudentName());
            }
        } catch (Exception e){
            System.out.println("Okunurken hata oluştu.");
            e.printStackTrace();
        }
    }
}
