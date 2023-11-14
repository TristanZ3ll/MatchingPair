import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your file: ");
        String userFile = input.nextLine();
        duoChecker check = new duoChecker(userFile);
        System.out.println("It is "+ check.duoCheck() + " that each symbol has a matching pair. ");
        input.close();
    }
}
