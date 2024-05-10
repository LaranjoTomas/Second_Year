package Aula11.Exer2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gradebook {

    ArrayList<Student> students = new ArrayList<Student>();

    public Gradebook() {
    }

    // Create the method load whice recieves a file name and reads all the data
    // written inside of it. It returns an ArrayList of Strings with all the words
    // inside the file its the parameter "Student name "
    public ArrayList<Student> load(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\|");
            String name = data[0];
            List<Double> grades = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                grades.add(Double.parseDouble(data[i]));
            }
            Student student = new Student(name, grades);
            students.add(student);
        }
        reader.close();
        return students;
    }

    // method addStudent, which adds a student to the class
    public void addStudent(Student student) {
        students.add(student);
    }

    // method removeStudent, which removes a student from the class
    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    // method getStudent, which gives an object student which contains the info of
    // the student with the name given
    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    // method calculateAverageGrade, which calculates the average grade of a student
    // given
    public double calculateAverageGrade(String string) {
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getName().equals(string)) {
                for (Double grade : student.getGrades()) {
                    sum += grade;
                    count++;
                }
                return sum / count;
            }
        }
        return 0;
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + " | Average Grade: "
                    + ((Math.round(calculateAverageGrade(student.getName()) * 100.0)) / 100.0));
        }
    }
}
