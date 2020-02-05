package Budget_Manager.stage2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu implements BudgetManager {
    @Override
    public void computeSelection() {
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        List<Integer> totalIncome = new ArrayList<>();
        boolean exit = false;


        do {
            String userChoice = scanner.next();
            switch (userChoice){
                case "1":
                    System.out.println("Enter Income:");
                    totalIncome.add(scanner.nextInt());
                    System.out.println("Income was added!");
                    displayMenu();
                    break;
                case "2":
                    displayMenu();
                    break;
                case "3":
                    displayMenu();
                    break;
                case "4":
                    System.out.println(returnAmountSpent(totalIncome));
                    displayMenu();
                    break;
                case "0":
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 4");
                    displayMenu();
            }
        }while (!exit);
    }

    private void displayMenu(){
        System.out.println("Choose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "0) Exit");
    }

    private static String returnAmountSpent(List<Integer> totalIncome){
        DecimalFormat staticDecimalFormat = new DecimalFormat("#.##");
        double result = 0.0;
        for (int value : totalIncome) {
            result += value;
        }
        return "Balance: $" + staticDecimalFormat.format(result);
    }
}
