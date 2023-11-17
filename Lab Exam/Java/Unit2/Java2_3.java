class Calculator {

    public static float calculateAverage (int... num) {

        if (num.length == 0) {
            return 0.0f;
        }

        int sum = 0;

        for (int i : num) {
            sum += i;
        }

        return ((float) sum)/ num.length;
    }
}

public class Java2_3 {
    public static void main(String[] args) {
        
        float avg = Calculator.calculateAverage(1, 2, 3, 4);

        System.out.println("Average of [1, 2, 3, 4]: " + avg);
    } 
}