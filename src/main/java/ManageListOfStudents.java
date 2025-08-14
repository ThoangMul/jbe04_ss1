import java.util.Scanner;

public class ManageListOfStudents {
    static final int MAX_STUDENTS = 100;
    static Student[] listStudents = new Student[MAX_STUDENTS];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        int choice;
        do {
            System.out.println(" Manage list of Students");
            System.out.println("1: Create a student");
            System.out.println("2: Display all");
            System.out.println("3: Find a student id");
            System.out.println("4: Update a student by id");
            System.out.println("5: Quit");
            System.out.println("Your choice:");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CreateStudent();
                    break;
                case 2:
                    DisplayAllStudents();
                    break;
                case 3:
                    FindStudentById();
                    break;
                case 4:
                    UpdateStudentByID();
                    break;
                case 5:
                    System.out.println("Quit!");
                    break;
                default:
                    System.out.println("Invalid your choice!");
            }
        } while (choice != 5);
    }
    private static void CreateStudent() {
        if (count >= MAX_STUDENTS) {
            System.out.println("Student list if full");
            return;
        }
        Student student = new Student();

        int id;
        boolean isDuplicateId;
        do {
            isDuplicateId = false;
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                if (listStudents[i].id == id) {
                    System.out.println("Error: ID already exists. Please enter a different ID.");
                    isDuplicateId = true;
                    break;
                }
            }
        } while (isDuplicateId);
        student.id = id;

        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Error: Name cannot be empty.");
            }
        } while (name.trim().isEmpty());
        student.name = name;

        int age;
        do {
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            if (age < 18) {
                System.out.println("Error: Age must be 18 or older.");
            }
        } while (age < 18);
        student.age = age;

        String gender;
        do {
            System.out.print("Enter gender (Male/Female): ");
            gender = scanner.nextLine();
            if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
                System.out.println("Error: Gender must be 'Male' or 'Female'.");
            }
        } while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"));
        student.gender = gender;

        System.out.print("Enter address: ");
        student.address = scanner.nextLine();

        System.out.print("Enter email: ");
        student.email = scanner.nextLine();

        listStudents[count] = student;
        count++;
        System.out.println("Create a student is success!");
    }

    private static void DisplayAllStudents() {
        if (count == 0) {
            System.out.println("List of student is empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent " + (i + 1) + " ");
            listStudents[i].display();
        }
    }

    private static void FindStudentById() {
        System.out.print("Enter student Id to find: ");
        int idToFind = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (listStudents[i].id == idToFind) {
                System.out.println("Found a student with:");
                listStudents[i].display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not found student with Id " + idToFind);
        }
    }

    private static void UpdateStudentByID() {
        System.out.println("Update a student by id");
        System.out.print("Enter student id: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();

        int foundIndex = -1;
        // Find student in list
        for (int i = 0; i < count; i++) {
            if (listStudents[i].id == idToUpdate) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            Student studentToUpdate = listStudents[foundIndex];
            System.out.println("Student found. Enter new information:");

            System.out.print("Enter new name (" + studentToUpdate.name + "): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                studentToUpdate.name = newName;
            }

            System.out.print("Enter new age (" + studentToUpdate.age + "): ");
            String newAgeStr = scanner.nextLine();

            if (!newAgeStr.isEmpty()) {
                int newAge = Integer.parseInt(newAgeStr);
                if (newAge >= 18) {
                    studentToUpdate.age = newAge;
                } else {
                    System.out.println("Error: Age must be 18 or older. Age not updated");
                }
            }

            System.out.print("Enter new address (" + studentToUpdate.address + "): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                studentToUpdate.address = newAddress;
            }

            System.out.print("Enter new gender (" + studentToUpdate.gender + "): ");
            String newGender = scanner.nextLine();
            if (!newGender.isEmpty()) {
                studentToUpdate.gender = newGender;
            }

            System.out.print("Enter new email (" + studentToUpdate.email + "): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                studentToUpdate.email = newEmail;
            }

            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Not found student with Id " + idToUpdate);
        }
    }
}