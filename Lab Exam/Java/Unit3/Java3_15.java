public class Java3_15 {
    
    public static int wrongBinarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr[arr.length]; //Intentionally making error

        while (low <= high) {
            
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } 
            
            else if (arr[mid] < key) {
                low = mid + 1;
            } 
            
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
    
    public static int binarySearch(int[] arr, int key) {
        
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } 
            
            else if (arr[mid] < key) {
                low = mid + 1;
            } 
            
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 6, 8, 10, 12, 14 };

        int key = 7;

        try {

            System.out.println("- - - - Correct Binary Search - - - -");

            int returnedIndex = binarySearch(arr, key);

            if (returnedIndex != -1) {
                System.out.println("Element " + key + " found at index " + returnedIndex);
            } 
            
            else {
                System.out.println("Element " + key + " not found in the array.");
            }

        } 
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException in correct binary search: " + e);
        }

        try {

            System.out.println("\n- - - - Wrong Binary Search - - - -");
            
            int index = wrongBinarySearch(arr, key);

            if (index != -1) {
                System.out.println("Element " + key + " found at index " + index);
            } 
            
            else {
                System.out.println("Element " + key + " not found in the array.");
            }

        } 
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException in wrong binary search: " + e);
        }
    }
}