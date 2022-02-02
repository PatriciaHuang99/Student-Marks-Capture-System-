import java.util.Scanner;
// DO NOT import anything else

/**
 * This class forms Java Assignment 1, 2021
 */
public class StudentMarking {

    /**
     * The message that the main menu must display --- DO NOT CHANGE THIS
     */
    public final String MENU_TEMPLATE =
            "%nWelcome to the Student System. Please enter an option 0 to 3%n"
                    + "0. Exit%n"
                    + "1. Generate a student ID%n"
                    + "2. Capture marks for students%n"
                    + "3. List student IDs and average mark%n";
    /**
     * DO NOT CHANGE THIS
     */
    public final String NOT_FOUND_TEMPLATE =
            "No student id of %s exists";

   /* Do NOT change the two templates ABOVE this comment.
      DO CHANGE the templates BELOW.
   */

    // TODO (All questions) - Complete these templates which will be used throughout the program
    public final String ENTER_MARK_TEMPLATE = "Please enter mark %s for student %s%n"; // Please enter mark 1 for student DR09il
    public final String STUDENT_ID_TEMPLATE = "Your studID is %s"; // Your studID is DP07ik
    public final String NAME_RESPONSE_TEMPLATE = "You entered a given name of %s and a surname of %s%n"; // You entered a given name of Daisy and a surname of Picking // padding with space
    public final String LOW_HIGH_TEMPLATE = "Student %s has a lowest mark of %d%nA highest mark of %d%n"; // Student LH08wl has a lowest mark of 5 A highest mark of 7
    public final String AVG_MARKS_TEMPLATE = "Student ***%s*** has an average of %5.2f%n"; // Student ***LH08wl*** has an average of  6.00
    public final String COLUMN_1_TEMPLATE = "%3s%s";
    public final String COLUMN_2_TEMPLATE = "%11s%s";
    public final String CHART_KEY_TEMPLATE = "%1s%3d%9s%3d%n";
    public final String REPORT_PER_STUD_TEMPLATE = "| Student ID %3d is %s | Average is %5.2f |%n"; // | Student ID   1 is TW04tl | Average is  3.33 |
    public final String RETURN_MAIN_MENU_CODE = "0";

    /**
     * Creates a student ID based on user input
     *
     * @param sc Scanner reading {@link System#in} re-used from {@link StudentMarking#main(String[])}
     * @return student ID based on user input
     */

    public String generateStudId(Scanner sc) {
        // TODO (3.4) - Complete the generateStudId method which will allow a user to generate a student id
        String studId = "generateStudId is incomplete"; // TODO Don't have unnecessary initialisations //done
        String name;
        String givenName = "";
        String familyName = "";
        char aCharA; // 4.1 the uppercase initial of the given name
        char aCharB; // 4.2 the uppercase initial of the family name
        String lengthC; // 4.3 the length of the family name, zero-padded to 2 digits
        String aCharD; // 4.4 the middle letter of the given name in its original case
        String aCharE; // 4.5 the middle letter of the family name in its original case

        System.out.printf(
                "Please enter your given name and surname (Enter 0 to return to main menu)%n");
        name = sc.nextLine();
        if (name.equals(RETURN_MAIN_MENU_CODE))
            return studId;

        for (int x = 0; x < name.length(); x++) {
            if (name.charAt(x) == ' ') {
                givenName = name.substring(0, x);
                familyName = name.substring(x + 1, name.length());
            }
        }
        aCharA = givenName.charAt(0);
        aCharA = Character.toUpperCase(aCharA); // 4.1
        String aCharAA = String.valueOf(aCharA); // Char transfer to String

        aCharB = familyName.charAt(0);
        aCharB = Character.toUpperCase(aCharB); // 4.2
        String aCharBB = String.valueOf(aCharB); // Char transfer to String

        int length = familyName.length();
        lengthC = String.format("%02d", length); // 4.3 // 00

        int firstLength = givenName.length();
        if (firstLength % 2 == 0) { // take the middle & later 1 char
            int startF = firstLength / 2;
            int endF = firstLength / 2 + 1;
            aCharD = givenName.substring(startF, endF); // 4.4
        } else { // take the middle 1 char
            int startF = (firstLength - 1) / 2;
            int endF = (firstLength - 1) / 2 + 1;
            aCharD = givenName.substring(startF, endF); // 4.4
        }

        int lastLength = familyName.length();
        if (lastLength % 2 == 0) { // take the middle later 1 char
            int startL = lastLength / 2;
            int endL = lastLength / 2 + 1;
            aCharE = familyName.substring(startL, endL); // 4.5
        } else { // take the middle 1 char
            int startL = (lastLength - 1) / 2;
            int endL = (lastLength - 1) / 2 + 1;
            aCharE = familyName.substring(startL, endL); // 4.5
        }

        studId = aCharAA + aCharBB + lengthC + aCharD + aCharE;
        System.out.printf(NAME_RESPONSE_TEMPLATE, givenName, familyName);
        System.out.printf(STUDENT_ID_TEMPLATE, studId);

        return studId;
    }

    /**
     * Reads three marks (restricted to a floor and ceiling) for a student and returns their mean
     *
     * @param sc     Scanner reading {@link System#in} re-used from {@link StudentMarking#main(String[])}
     * @param studId a well-formed ID created by {@link StudentMarking#generateStudId(Scanner)}
     * @return the mean of the three marks entered for the student
     */
    public double captureMarks(Scanner sc, String studId) {
        // TODO (3.5) - Complete the captureMarks method which will allow a user to input three mark for a chosen student
        // DO NOT change MAX_MARK and MIN_MARK
        final int MAX_MARK = 100;
        final int MIN_MARK = 0;
        int[] perStudentMark = new int[3];

        //outer loop to make sure enter 3 mark
        //for loop
        //inter loop to make sure the mark is within range
        //while loop

        System.out.printf(ENTER_MARK_TEMPLATE, "1", studId);

        int mark1 = sc.nextInt();
        sc.nextLine();
        if (mark1 >= MIN_MARK && mark1 <= MAX_MARK)
            perStudentMark[0] = mark1;

        System.out.printf(ENTER_MARK_TEMPLATE, "2", studId);
        int mark2 = sc.nextInt();
        sc.nextLine();
        if (mark1 >= MIN_MARK && mark1 <= MAX_MARK)
            perStudentMark[1] = mark2;

        System.out.printf(ENTER_MARK_TEMPLATE, "3", studId);
        int mark3 = sc.nextInt();
        sc.nextLine();
        if (mark1 >= MIN_MARK && mark1 <= MAX_MARK)
            perStudentMark[2] = mark3;

        int max = perStudentMark[0];
        for (int i = 1; i < perStudentMark.length; i++) {
            if (perStudentMark[i] > max) {
                max = perStudentMark[i];
            }
        }

        int min = perStudentMark[0];
        for (int i = 1; i < perStudentMark.length; i++) {
            if (perStudentMark[i] < min) {
                min = perStudentMark[i];
            }
        }

        double avg; // TODO Don't have unnecessary initialisations
        double total = (mark1 + mark2 + mark3);

        avg = total / 3;
        System.out.printf(LOW_HIGH_TEMPLATE, studId, min, max);
        System.out.printf(AVG_MARKS_TEMPLATE, studId, avg);

        System.out.printf("Would you like to print a bar chart? [y/n]%n");
        String decision = sc.nextLine();
        if (decision.equals("Y") || decision.equals("y"))
            printBarChart(studId, max, min);

        return avg;
    }

    /**
     * outputs a simple character-based vertical bar chart with 2 columns
     *
     * @param studId a well-formed ID created by {@link StudentMarking#generateStudId(Scanner)}
     * @param high   a student's highest mark
     * @param low    a student's lowest mark
     */

    public void printBarChart(String studId, int high, int low) {
        // TODO (3.6) - Complete the printBarChart method which will print a bar chart of the highest and lowest results of a student
        System.out.printf("Student id statistics: %s%n", studId);

        final char STAR = '*';

        for (x = 0; x < high; x++) {
            if (x < (high - low)) {
                System.out.printf(COLUMN_1_TEMPLATE + "%n", " ", STAR);
            } else {
                System.out.printf(COLUMN_1_TEMPLATE + COLUMN_2_TEMPLATE + "%n", " ", "*", " ", STAR);
            }
        }
        System.out.printf("Highest %3s Lowest%n", " ");
        System.out.printf(CHART_KEY_TEMPLATE, " ", high, " ", low);
    }

    /**
     * Prints a specially formatted report, one line per student
     *
     * @param studList student IDs originally generated by {@link StudentMarking#generateStudId(Scanner)}
     * @param count    the total number of students in the system
     * @param avgArray mean (average) marks
     */
    int x = -1;

    public void reportPerStud(String[] studList,
                              int count,
                              double[] avgArray) {
        // TODO (3.7) - Complete the reportPerStud method which will print all student IDs and average marks
        for (x = 0; x < count; x++) {
            System.out.printf(REPORT_PER_STUD_TEMPLATE, (x + 1), studList[x], avgArray[x]);
        }
    }

    /**
     * The main menu
     */
    public void displayMenu() {
        // TODO (3.2) - Complete the displayMenu method to use the appropriate template with printf
        System.out.printf(MENU_TEMPLATE);
    }

    /**
     * The controlling logic of the program. Creates and re-uses a {@link Scanner} that reads from {@link System#in}.
     *
     * @param args Command-line parameters (ignored)
     */

    public static void main(String[] args) {
        // TODO (3.3) - Complete the main method to give the program its core
        // DO NOT change sc, sm, EXIT_CODE, and MAX_STUDENTS

        Scanner sc = new Scanner(System.in);
        StudentMarking sm = new StudentMarking();
        final int EXIT_CODE = 0;
        final int MAX_STUDENTS = 5;
        final String RETURN_MAIN_MENU_CODE = "0";
        String studId;

        // TODO Initialise these
        String[] keepStudId = new String[MAX_STUDENTS];
        double[] avgArray = new double[MAX_STUDENTS];

        // TODO Build a loop around displaying the menu and reading then processing input
        int count = 0;

        while (true) {
            sm.displayMenu();
            int input = sc.nextInt();
            sc.nextLine();

            if (input == EXIT_CODE)
                break;

            else if (input == 1) {
                if (count > 4) {
                    System.out.printf("You cannot add any more students to the array");
                    continue;
                }
                studId = sm.generateStudId(sc);
                if (studId.equals("generateStudId is incomplete"))
                    continue;
                else {
                    keepStudId[count] = studId;
                    count += 1;
                }

            } else if (input == 2) {
                System.out.printf("Please enter the studId to capture their marks (Enter 0 to return to main menu)%n");
                studId = sc.nextLine();
                if (studId.equals(RETURN_MAIN_MENU_CODE))
                    continue;

                boolean studIdFound = false;
                int countStudent = -1;  // give a default value
                for (int x = 0; x < keepStudId.length; x++) {
                    if (studId.equals(keepStudId[x])) {
                        studIdFound = true;
                        countStudent = x;
                        break;
                    }
                }

                if (studIdFound) {
                    avgArray[countStudent] = sm.captureMarks(sc, studId);
                } else {
                    System.out.printf(sm.NOT_FOUND_TEMPLATE, studId); // way to access non-static final
                }

            } else if (input == 3) {
                sm.reportPerStud(keepStudId, count, avgArray);
            } else {
                // Handle invalid main menu input
                System.out.printf(
                        "You have entered an invalid option. Enter 0, 1, 2 or 3%n");// Skeleton: keep, unchanged
            }
        }
        System.out.printf("Goodbye%n");
    }
}

/*
    TODO Before you submit:
         1. ensure your code compiles
         2. ensure your code does not print anything it is not supposed to
         3. ensure your code has not changed any of the class or method signatures from the skeleton code
         4. check the Problems tab for the specific types of problems listed in the assignment document
         5. reformat your code: Code > Reformat Code
         6. ensure your code still compiles (yes, again)
 */