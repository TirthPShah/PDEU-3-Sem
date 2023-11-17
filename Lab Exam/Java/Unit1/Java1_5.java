import java.util.*;

public class Java1_5 {

    public static boolean isSpace(char ch) {
        return ch == ' ' || ch == '\t';
    }

    public static boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        int count = 0;
        int length = str.length();

        for (int i = 0; i < length - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);

            if ((i == 0 && isCapital(currentChar)) || (isSpace(currentChar) && isCapital(nextChar))) {
                count++;
            }
        }

        System.out.println("Number of words starting with capital letter are: " + count);

        System.out.println();

        sc.close();
    }
}
