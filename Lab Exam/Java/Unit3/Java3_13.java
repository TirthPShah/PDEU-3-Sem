class InvalidAgeException extends RuntimeException {}

class User {

    private int age;

    public User(int age) {
        this.age = age;
    }

    public void applyForVehicleLicense() throws InvalidAgeException {
        
        if (age < 18) {
            throw new InvalidAgeException();
        } 
        
        else {
            System.out.println("You are eligible for vehicle license.");
        }
    }

}

public class Java3_13 {

    public static void main(String[] args) {

        User user1 = new User(15);
        User user2 = new User(20);

        System.out.println("- - - - User 1 Applying for Vehicle License - - - -");

        try {
            user1.applyForVehicleLicense();
        }

        catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\n- - - - User 2 Applying for Vehicle License - - - -");

        user2.applyForVehicleLicense();
    }
}