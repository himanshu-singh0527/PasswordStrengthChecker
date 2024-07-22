import java.util.*;

public class passwordStrength {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        // Prompt the user to input a password
        System.out.print("Enter a password to check its strength: ");
        String password = sc.nextLine();

        // Check the strength of the password
        String strength = checkPasswordStrength(password);

        // Display the result
        System.out.println("Password Strength: " + strength);
    }

    private static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak: Password is too short. It should be at least 8 characters.";
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecial) {
            return "Strong: Password meets all criteria.";
        } else if (hasUppercase && hasLowercase && hasDigit) {
            return "Moderate: Password is missing special characters.";
        } else if (hasUppercase && hasLowercase) {
            return "Weak: Password is missing digits and special characters.";
        } else if (hasUppercase || hasLowercase) {
            return "Very Weak: Password is missing digits, special characters, and has poor length.";
        } else {
            return "Very Weak: Password does not contain uppercase letters, lowercase letters, digits, or special characters.";
        }
    }
}
