import java.util.Scanner;

//Main
class Main {
    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int vowels = 0, consonants = 0;

        // Convert the string to lowercase
        line = line.toLowerCase();

        for (int i = 0; i < line.length(); ++i) {

            // take each character from the string
            char ch = line.charAt(i);
            // check if the character is a vowel or consonant
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }

        }
        // Print the number of vowels and consonants
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        // Close the scanner
        sc.close();

    }
}