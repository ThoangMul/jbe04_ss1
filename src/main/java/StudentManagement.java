import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Student[] students = new Student[100];
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String choice;

        final String ADD = "1";
        final String SHOW = "2";
        final String EXIT = "3";

        do {
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case ADD:
                    if (count >= students.length) {
                        System.out.println("Student list is full");
                        break;
                    }
                    Student student = new Student();

                    System.out.println("Enter student name: ");
                    student.name = scanner.nextLine();

                    System.out.println("Enter mark 1: ");
                    student.mark1 = Float.parseFloat(scanner.nextLine());

                    System.out.println("Enter mark 2: ");
                    student.mark2 = Float.parseFloat(scanner.nextLine());

                    System.out.println("Enter mark 3: ");
                    student.mark3 = Float.parseFloat(scanner.nextLine());

                    students[count++] = student;
                    break;
                case SHOW:
                    System.out.println("List of student");
                    for (int i = 0; i <count; i++) {
                    System.out.println("Student " + (i + 1) + ":");
                    System.out.println("Name: " + students[i].name);
                    System.out.println("Mark1: " + students[i].mark1);
                    System.out.println("Mark2: " + students[i].mark2);
                    System.out.println("Mark3: " + students[i].mark3);
                    System.out.println("Total: " + students[i].total());
                    System.out.println("Average: " + students[i].average());
                }
                break;
            }
        } while (!choice.equals(EXIT));
    }
}