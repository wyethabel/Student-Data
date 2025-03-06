/* Main running class designed to provide a user a looping option
   to submit student information as defined by the Student class,
   which is stored and exported as soon as the user is done.
 */
import java.util.*;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Student> studentEntry = new LinkedList<>();

        while (true) {
            // Continuation check
            System.out.println("Continue with entering student information? (Y/N): ");
            String selection = input.nextLine();
            if (selection.equals("N")) {
                break;
            } else if (!selection.equals("Y")) {
                System.out.println("Please enter Y for yes and N for no.");
                continue;
            }

            // Info entry if user chooses to continue
            System.out.println("Please enter the student's name: ");
            String studentName = input.nextLine();
            System.out.println("Please enter the student's address: ");
            String studentAddress = input.nextLine();

            //GPA verification
            double studentGPA;
            while (true) {
                System.out.println("Please enter the student's GPA as a value between 0 and 4 " +
                        "with exactly two decimal places (0.00 - 4.00): ");
                String tempGPA = input.nextLine().trim();
                // Regex statement to enforce two decimal digit entry and range requirements
                if (!tempGPA.matches("([0-3]\\.\\d{2}|4\\.00)")) {
                    System.out.println("Input did not match the requested constraints.");
                    continue;
                }
                // Edge-case validation
                try {
                    studentGPA = Double.parseDouble(tempGPA);
                    break;
                } catch (Exception e) {
                    System.out.println("Input did not match the requested constraints.");
                }
            }
            studentEntry.add(new Student(studentName, studentAddress, studentGPA));
        }

        // Sort and write
        studentEntry.sort(new NameSort());
        try (FileWriter writer = new FileWriter("src/Student_Information.txt", true)) {
            for (Student i : studentEntry) {
                writer.write("Name: " + i.getName() + " Address: " + i.getAddress() +
                        " GPA: " + i.getGPA() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Unable to save student data: " + e.getMessage());
        }
        input.close();
    }
}