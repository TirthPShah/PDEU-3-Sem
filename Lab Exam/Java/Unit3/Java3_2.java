import java.io.*;

public class Java3_2 {
    public static void main(String[] args) {
        
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("SecondSource.txt"));
            bw = new BufferedWriter(new FileWriter("SecondDestination.txt"));
            
            String toFind = "Tirth";
            String toReplace = "Oracle";

            String name = br.readLine();
            
            while(name != null) {

                name = name.replaceAll(toFind, toReplace);

                bw.append(name);
                bw.append("\n");

                name = br.readLine();
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {

            try {
                br.close();
                bw.close();
            }

            catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }
}
