package homework.Std;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestStore {
    public static void main(String[] args) {
        try{
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student(1, "halil"));
            studentList.add(new Student(2, "halil2"));
            studentList.add(new Student(3, "halil3"));
            String path = Paths.get("").toAbsolutePath().toString() + "/text.txt";
            StudentFiler filer = new StudentFiler(path);
            filer.Store(studentList);
        }catch (Exception e){
            System.out.println("Yazarken hata oluştu.");
            e.printStackTrace();
        }
    }
}
