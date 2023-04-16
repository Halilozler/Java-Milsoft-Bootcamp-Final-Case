package homework.Std;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFiler {
    private  String filePath;
    private StudentService _studentService;

    public StudentFiler(String filePath) {
        this.filePath = filePath;
        _studentService = new StudentService();
    }

    public void Store(List<Student> studentList) throws IOException {
        //Write
        //nereye gidilecek onun path verdik.
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter writer = new BufferedWriter(fw);
        //dosya içine yazar.
        for(Student student : studentList){
            writer.append(_studentService.Format(student) + "\n");
        }
        writer.close();
    }
    public List<Student> Load() throws IOException {
        //Read
            FileReader fr = new FileReader(filePath);
            //Buffer alanımıza yazıyoruz
            BufferedReader reader = new BufferedReader(fr);

            String line = "";
            List<Student> resultList = new ArrayList<>();
            //string builder kullanırız.
            StringBuilder builder = new StringBuilder();

            while((line = reader.readLine()) != null){
                //text = line + "\r\n";
                resultList.add(_studentService.Parse(line));
            }

            reader.close();
            return resultList;
    }
}
