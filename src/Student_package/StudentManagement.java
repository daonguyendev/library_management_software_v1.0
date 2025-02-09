package Student_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;
    private final String filePath = "students.csv";

    private static StudentManagement studentManagement = new StudentManagement();

    public static StudentManagement getStudentManagement() {
        return studentManagement;
    }

    private StudentManagement() {
        this.students = new ArrayList<>();
        readFromFile();
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public boolean remove(int id) {
        Student searchStudent = searchByID(id);
        if (searchStudent != null) {
            this.students.remove(searchStudent);
            return true;
        }
        return false;
    }

    public Student searchByID(int id) {
        for (Student student : this.students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchByName(String name) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getName().contains(name)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public void saveToFile(){
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student student : this.students) {
                bw.write(student.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public void readFromFile() {
        try {
            this.students.clear();
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Student student;
            while ((line = br.readLine()) != null) {
                student = handleLine(line);
                this.students.add(student);
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public Student handleLine(String line) {
        String[] str = line.split(",");
        return new Student(Integer.parseInt(str[0]), str[1], str[2], Boolean.parseBoolean(str[3]));
    }

    public String display() {
        String listStudent = "";
        for (Student student : this.students) {
            listStudent += student.toString() + "\n";
        }
        return listStudent;
    }

}
