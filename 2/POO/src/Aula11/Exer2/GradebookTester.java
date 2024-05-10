package Aula11.Exer2;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class GradebookTester {
    public static void main(String[] args) throws IOException {
        // Create a new Gradebook instance
        Gradebook gradebook = new Gradebook();

        // Load the student data from a text file
        gradebook.load("../src/Aula11/Exer2/alunos.txt");

        // Add a new student to the collection
        Student newStudent = new Student("Johny May", new ArrayList<>(List.of(10.0, 15.0, 19.0)));
        gradebook.addStudent(newStudent);

        // Remove a student from the collection
        gradebook.removeStudent("Jane Smith");

        // Retrieve a student from the collection
        Student student = gradebook.getStudent("John Doe");
        System.out.println("Retrieved student is " + student);

        // Calculate the average grade for a specific student
        double averageGrade = gradebook.calculateAverageGrade("John Doe");
        System.out.println("Average grade for John Doe: " + averageGrade);

        // Print a summary of all students in the collection
        gradebook.printAllStudents();
    }
}
