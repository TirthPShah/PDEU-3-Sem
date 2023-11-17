import java.io.*;

public class Java3_14 {

    public static void main(String[] args) {

        //Nested Catch
        
        try {
            
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]);
        
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("\nArrayIndexOutOfBoundsException: " + e);
        
        } catch (ArithmeticException e) {

            System.out.println("\nArithmeticException: " + e);
        
        } catch (Exception e) {

            System.out.println("\nGeneral Exception: " + e);
        
        }
        
        //Nested Try

        try {

            performFileOperation("nonexistent_file.txt");
        
        } catch (FileNotFoundException e) {

            System.out.println("\nFileNotFoundException inside Main: " + e);
        
        } catch (IOException e) {

            System.out.println("\nIOException insideMain: " + e);
        
        } catch (Exception e) {

            System.out.println("\nGeneral Exception inside Main: " + e);
        
        }
    }

    //Nested Try
    public static void performFileOperation(String fileName) throws IOException {
        
        try {

            BufferedReader reader = new BufferedReader(new FileReader("FourteenthInput.txt"));

            try {

                String line;

                while ((line = reader.readLine()) != null) {

                    try {

                        int value = Integer.parseInt(line);
                        int result = 100 / value;

                        BufferedWriter writer = new BufferedWriter(new FileWriter("FourteenthOutput.txt", false));

                        try {
                            writer.append("Result: " + result + "\n");
                        } 
                        
                        finally {
                            writer.close();
                        }

                    } 
                    
                    catch (NumberFormatException e) {
                        System.out.println("Inner catch: NumberFormatException - " + e);
                    } 
                    
                    catch (ArithmeticException e) {
                        System.out.println("Inner catch: ArithmeticException - " + e);
                    }
                }

            }
            
            catch (Exception e) {
                System.out.println("Error for middle try: " + e);
            }
            
            finally {
                reader.close(); // Close the input file
            }

        } 
        
        catch (IOException e) {
            System.out.println("Outer catch: IOException - " + e);
        }
    }
}