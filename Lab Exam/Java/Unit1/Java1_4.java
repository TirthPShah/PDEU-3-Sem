import java.util.*;

public class Java1_4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the string: ");
        String str = sc.nextLine();

        str = str.toLowerCase();

        System.out.println();

        int vowelcnt = 0;
        int consocnt = 0;

        char curr;

        for(int i=0; i<str.length(); i++) {
            
            curr = str.charAt(i);

            if(curr >= 'a' && curr <= 'z') {
                if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
                    vowelcnt++;
                }
                else {
                    consocnt++;
                }
            }

        }

        System.out.println("\nNumber of Vowels: " + vowelcnt);
        System.out.println("\nNumber of Consonants: " + consocnt);

        System.out.println();

        sc.close();
    }
}
