import java.io.*;
import java.util.*;

public class Java3_5 {
    
    public static void encrypt(InputStream isForSource, int key) {

        OutputStream enc = null;

        try {

            int data = isForSource.read();

            enc = new FileOutputStream("FifthEncrypted.txt");

            while(data != -1) {

                data += key;
                enc.write(data);
                System.out.println((char)data);
                data = isForSource.read();

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {

            try {
                enc.close();
            }
            
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void decrypt(InputStream isForDecrpyt, OutputStream dec, int key) {

        try {

            int data = isForDecrpyt.read();

            while(data != -1) {

                data -= key;
                dec.write(data);
                System.out.println((char)data);
                data = isForDecrpyt.read();

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {

            try {
                dec.close();
            }
            
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        
        String fileSource = args[0];

        Scanner sc = new Scanner(System.in);

        InputStream isForSource = null;
        InputStream isForDecrpyt = null;
        OutputStream dec = null;

        System.out.print("Enter the encryption key: ");
        int key = sc.nextInt();

        try {
            
            isForSource = new FileInputStream(fileSource);
            
            isForDecrpyt = new FileInputStream("FifthEncrypted.txt");
            dec = new FileOutputStream("FifthDecrypted.txt");

            encrypt(isForSource, key);
            decrypt(isForDecrpyt, dec, key);

        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {

            try {
                sc.close();
                isForSource.close();
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
