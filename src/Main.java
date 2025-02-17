public class Main {
    public static void printLetter(String offense, String numberOfOffenses) {
        // Method will handle printing the complete letter
        System.out.println("---Complete Letter---");
        System.out.println();

    }
    public static void printLetterWithPrompts() {
        // Method will handle with printing the incomplete letter and will call the method "choices" to deal choices
        // Method will also call the complete letter method and pass the choices through as strings
        System.out.println("---Incomplete Letter---");
        System.out.println();

        String offense = offenseType();
        String numberOfOffenses = numberOfOffense();
    }

    public static String offenseType() {
        // Method prints out the choices associated with offenses, and returns a String value
        String offenseOption;
        byte option;

        return offenseOption;
    }

    public static String numberOfOffense() {
        // Method prints out the choices associated with number of offenses, and returns a String value
        String offenseNumber;
        byte option;

        return offenseNumber;
    }

    public static void main(String[] args) {
        printLetter();
    }
}