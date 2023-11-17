import java.util.*;

public class Java1_8 {

    public static void sort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {

            for(int j=i+1; j<n; j++) {

                if(arr[j] < arr[i]) {

                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }

            }

        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter the number of elements in array: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("\nEnter the elements of the array: ");

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray before sorting: ");

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sort(arr);

        System.out.println("\nArray after sorting: ");

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n2");

        sc.close();
    }
}