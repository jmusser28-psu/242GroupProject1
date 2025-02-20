import java.util.Scanner;

public class Main {
    public static void printLetter(String professorName, String course, byte week, String[] violations,
                                   String violationStatement, String firstOrSecond) {

        System.out.printf("Dear Professor %s,", professorName);
        System.out.println();

        System.out.println("As you may know, May Dee Ocre University’s Office of Academic Operations strives to " +
                "enhance the student experience and ensure best practices in our classes.");
        System.out.println("To that end, faculty and " +
                "student interactions are recorded weekly in the CLAP Learning Management System.");
        System.out.println("Additionally, each week, classroom reviews are conducted to ensure that records are kept up-" +
                "to-date and that our students are fully aware of their progress toward success.");
        System.out.println("The components reviewed include posting of grades, " +
                "including zeros, posting of participation and attendance," +
                "and that class was held and for the scheduled length.");
        System.out.println();

        System.out.printf("In reviewing your CLAP course, %s, for Week %d, it was noticed that you have neglected to: \n", course, week);
        for (String element : violations) {
            System.out.println("    - " + element);
        }
        System.out.println();

        System.out.printf("This is the %s observation that your class was missing a vital component. This is just a friendly " +
                "reminder to update CLAP as soon as possible.\n", firstOrSecond);
        System.out.println("It is understood that things happen sometimes and that mistakes do occur.");
        System.out.println();

        System.out.println("Please take some time to review Faculty Expectations by viewing these links:");
        System.out.println("    - Faculty Handbook: https://drive.google.com/filex/d/1f1fYW1_V6ye24E-" +
                "QttXM3i8OvxDiqnp2/view?pli=132");
        System.out.println("    - Faculty Performance Effectiveness chart: " +
                "https://drive.google.com/filex/d/10gJj08amTbcajq9jQvVqq5eVNy9oLkzrZ/view2");
        System.out.println("    - Faculty FAQ’s: https://docs.google.com/document/d/1S1gmRfC3-" +
                "JFCH8MZNIsUkh10pxhC_iJ8GKU131i7RXy4/edit");
        System.out.println();

        System.out.println(violationStatement);

        System.out.println("Please keep in mind that these issues are raised out of concern for you, as a practicing " +
                "instructor, and for the integrity of our classes and the needs of our students.");
        System.out.println("You are a valued asset at May Dee Ocre University.");
        System.out.println();

        System.out.println("Finally, please acknowledge receipt of this message, " +
                "making sure to copy Dr. Bill Riter, Director " +
                "of Academic Operations (billriter@maydeeocre.edu).");
        System.out.println("If this message is arriving after you have " +
                "already attended to these issues, please still acknowledge receipt of this message and indicate " +
                "that you have remedied the situation.");
        System.out.println();

        System.out.println("If you have any questions or concerns, please let me know immediately.");
        System.out.println();

        System.out.println("Sincerely,");
        System.out.println("Frank N. Stein");
        System.out.println("CoTE, Program Chair");
        System.out.println("Graduate Studies");
    }

    public static String getProfessorName(Scanner scnr) {
        String professorName = "";

        System.out.print("Please enter the name of the professor: ");
        professorName = scnr.nextLine();

        return professorName;
    }

    public static String getCourseInfo(Scanner scnr) {
        String courseName = "";
        System.out.print("Please enter the course name and number: ");
        courseName = scnr.nextLine();

        return courseName;
    }

    public static byte getWeekNumber(Scanner scnr) {
        byte week = 0;
        System.out.print("What week of instruction did the incident occur? (Value): ");
        while (week < 1) {
            week = validateByte(scnr);
            if (week < 1) {
                System.out.print("Please enter a valid week value: ");
            }
        }

        return week;
    }

    public static String[] getViolations(Scanner scnr) {
        byte violationNum = 0;
        byte violationType = 0;
        String[] violations;

        System.out.println("Types of violations:");
        System.out.println("1 - Participate in the Discussion Board Thread");
        System.out.println("2 - Enter Grades (including all zeros)");
        System.out.println("3 - Enter Participation");
        System.out.println("4 - Enter Attendance");

        System.out.print("How many violations occurred? ");
        while (violationNum < 1) {
            violationNum = validateByte(scnr);
            if (violationNum < 1) {
                System.out.print("Please enter a valid number of violations: ");
            }
        }

        violations = new String[violationNum];

        for (int i = 0; i < violationNum; i++) {
            System.out.print("Please enter the type of violation that occured (1-4): ");
            violationType = validateByte(scnr);
            if (violationType == 1) {
                violations[i] = "Participate in the discussion board thread.";
            }
            else if (violationType == 2) {
                violations[i] = "Enter Grades (including all zeros)";
            }
            else if (violationType == 3) {
                violations[i] = "Enter Participation";
            }
            else if (violationType == 4) {
                violations[i] = "Enter Attendance";

            }
            else {
                System.out.println("Please enter a valid violation number");
                i--;
            }
        }

        return violations;
    }

    public static byte getFrequencyOfViolations(Scanner scnr) {
        byte numberOfViolations = 0;
        byte userChoice = 0;
        boolean valid = false;
        System.out.print("Is this the first or second violation? (1-2): ");

        while (!valid) {
            userChoice = validateByte(scnr);
            if (userChoice == 1) {
                numberOfViolations = 1;
                valid = true;
            }
            else if (userChoice == 2) {
                numberOfViolations = 2;
                valid = true;
            }
            else {
                System.out.print("Please enter a valid choice: ");
            }
        }
        System.out.println();

        return numberOfViolations;
    }

    public static byte validateByte(Scanner scnr) {
        boolean valid = false;
        byte byteToCheck = 0;

        while (!valid) {
            if (scnr.hasNextByte()) {
                valid = true;
                byteToCheck = scnr.nextByte();
                scnr.nextLine();
            }
            else {
                scnr.nextLine();
                System.out.print("Please enter a valid value: ");
            }
        }

        return byteToCheck;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String professorName = getProfessorName(scnr);
        String course = getCourseInfo(scnr);
        byte week = getWeekNumber(scnr);
        String[] violations = getViolations(scnr);
        byte violationsFrequency = getFrequencyOfViolations(scnr);
        String firstOrSecond = "";

        if (violationsFrequency == 1) {
            firstOrSecond = "first";
        }
        else {
            firstOrSecond = "second";
        }

        String violationStatement = "";
        if (violationsFrequency == 1) {
            violationStatement = "Moving forward, a second such incident will require a Second Event Memo " +
                    "to be sent, and a meeting requested to address relevant issues and needs.";
        }

        else {
            violationStatement = "Given this is the second incident, you will be contacted to establish the " +
                    "next steps to ensure the timely completion of classroom procedures";
        }

        printLetter(professorName, course, week, violations, violationStatement, firstOrSecond);
    }

}