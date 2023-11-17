import java.io.*;
import java.util.HashSet;

public class Java3_3 {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
        
            br = new BufferedReader(new FileReader("ThirdSource.txt"));
            bw = new BufferedWriter(new FileWriter("ThirdDestination.txt"));

            String line = br.readLine();

            HashSet<String> uniqueLines = new HashSet<>();

            while (line != null) {

                if (uniqueLines.add(line)) {
                    bw.append(line);
                    bw.append("\n");
                }

                line = br.readLine();

            }
            
        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }

        finally {

            try {

                bw.close();
                br.close();

            }

            catch (Exception e) {

                System.out.println("Error: " + e);

            }

        }
    }
}