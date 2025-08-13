import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class StudentManagement {
    public static void main(String[] args) {
        Student[] students = new Student[100];
        byte count = 0;
        Scanner scanner = new Scanner(System.in);
        String choice;

        final String ADD = "1";
        final String SHOW = "2";
        final String EXIT = "3";

        do {
            System.out.println("1.Add student: ");
            System.out.println("2.Show all students: ");
            System.out.println("3.Exit ");

            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case ADD:
                    if (count >= students.length) {
                        System.out.println("Student list is full");
                        break;
                    }
                    Student student = new Student();

                    System.out.println("Enter student name");
                    System.out.println("Enter mark 1: ");
                    System.out.println("Enter mark 1: ");
                    System.out.println("Enter mark 1: ");

            }
