import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentTest {

    public static void main(String[] args) {
//        Student sA = new Student(1, "Tín", null);
//        Student sB = new Student(2, "Đức", null);
//        Student[] students = {sA, sB};
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }

//        String phanTu1 = "Tèo";
//        Integer phanTu2 = 1;
//        Boolean phanTu3 = true;
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(phanTu1);
//        arrayList.add(phanTu2);
//        arrayList.add(phanTu3);

//        for (Object item: arrayList) {
//            System.out.println(item);
//            if (item == true) {
//
//            }
//        }

//        for (int i=0; i<arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

//        ArrayList<Student> danhSach2 = new ArrayList<>();
//        String phanTu1 = "Tèo";
//        Integer phanTu2 = 1;
//        Boolean phanTu3 = true;
//        Student phanTu4 = new Student(1, "Tín", null);
//        danhSach2.add(phanTu1);
//        danhSach2.add(phanTu2);
//        danhSach2.add(phanTu3);
//        danhSach2.add(phanTu4);

        LinkedList<Student> list1 = new LinkedList<>();
        list1.add(new Student(1, "Tín", null));
        list1.add(new Student(2, "Đức", null));
        for (Student student: list1) {
            System.out.println(student);
        }

        ArrayList<Student> list2 = new ArrayList<>();
        for (Student student: list1) {
            list2.add(student);
        }
        for (Student student: list2) {
            System.out.println(student);
        }

        List<Student> list3 = new LinkedList<>();
        list3.add(new Student(1, "Tý", null));
        list3.add(new Student(2, "Tèo", null));
        for (Student student: list3) {
            System.out.println(student);
        }
        List<Student> list4 = new ArrayList<>(list3);
        for (Student student: list4) {
            System.out.println(student);
        }

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(5);
        set1.add(7);
        set1.add(9);
        set1.add(7);
        System.out.println(set1);

        Set<Student> set2 = new HashSet<>();
        set2.add(new Student(1, "Tý", null));
        set2.add(new Student(1, "Tý", null));
        System.out.println(set2);

        Set<String> set3 = new HashSet<>();
        set3.add("Tý");
        set3.add("Tèo");
        set3.add("Tý");
        System.out.println(set3);

        // 8 primitive data types:
        // byte, short, int, long, float, double, char, boolean

        // 8 Wrapper Class data types:
        // Byte, Short, Integer, Long, Float, Double, Character, Boolean

        // primitive data types # Wrapper Class data types?
        // int # Integer?
        int a = 3;

        Integer b = 5;
        Float c = Float.parseFloat(String.valueOf(b));

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Tín");
        map1.put(2, "Tý");
        map1.put(2, "Đức");
        map1.put(3, "Đức");
        System.out.println(map1);
        Map<Integer, String> map2 = new LinkedHashMap<>(map1);
        System.out.println(map2);

    }
}
