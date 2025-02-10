package package2;

import package1.Person;

class Student extends Person {

    public Student(int id, String name) {
        super(id, name);
    }

    public static void main(String[] args) {
        Student studentA = new Student(1, "Tèo");
        System.out.println(studentA.name);

    }
}
