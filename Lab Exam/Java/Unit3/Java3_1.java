import java.io.*;

public class Java3_1 {
    public static void main(String[] args) {
        
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {

            br = new BufferedReader(new FileReader("FirstSource.txt"));
            bw = new BufferedWriter(new FileWriter("FirstDestination.txt"));

            String line = br.readLine();

            while (line != null) {
                    
                bw.append(line.toLowerCase());
                bw.append("\n");
    
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