import java.util.*;
import java.io.*;

public class Java3_4 {

    public static void storeInput(int num, Scanner sc, BufferedWriter bw) {
        
        try {

            bw = new BufferedWriter(new FileWriter("markdetails.txt"));

            for (int i = 1; i <= num; i++) {

                System.out.print("\nEnter the name of the " + i + "th person: ");
                String name = sc.nextLine().trim();

                System.out.print("Enter marks for " + name + ": ");
                int marks = sc.nextInt();

                sc.nextLine();

                bw.write(name + " " + marks);
                bw.newLine();

            }
            
        } 
        
        catch (Exception e) {
            System.out.println("Error: " + e);
        } 
        
        finally {
            
            try {
                bw.close();
            } 
            
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static void readInput(int num, Scanner sc, BufferedReader br) {
        
        try {

            br = new BufferedReader(new FileReader("markdetails.txt"));

            String line = br.readLine();

            System.out.println();

            while(line != null) {

                String[] splitted = line.split(" ");

                int marks = Integer.parseInt(splitted[1]);

                if (marks > 70) {
                    System.out.println(splitted[0] + " has scored " + marks + " marks.");
                }

                line = br.readLine();
            }

            System.out.println();

        } 
        
        catch (Exception e) {
            System.out.println("Error: " + e);
        } 
        
        finally {

            try {
                br.close();
            } 
            
            catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;
        BufferedWriter bw = null;

        System.out.print("\nEnter the number of entries: ");
        int num = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        storeInput(num, sc, bw);
        readInput(num, sc, br);

    }
}