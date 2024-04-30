package computerdamagereportsystem;
import java.util.Scanner;


public class Login {

    Scanner sc = new Scanner(System.in);
    String userName = "admin";
    String userPass = "admin123";

    public void signIn() {
        try {
            String inputUser;
            String inputPass;
            boolean isValid = false;

            while (!isValid) {
                System.out.print("Username: ");
                inputUser = sc.nextLine();
                System.out.print("Password: ");
                inputPass = sc.nextLine();

                if (inputUser.equals(userName) && inputPass.equals(userPass)) {
                    isValid = true;
                } else {
                    System.out.println("Invalid Username or Password");
                }
            }
        } catch (Exception e) {

        } finally {
            System.out.println("You've Successfully Login!\n");
        }
    }
}
