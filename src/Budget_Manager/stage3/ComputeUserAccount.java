package Budget_Manager.stage3;

import java.util.*;

public class ComputeUserAccount implements BudgetManager {
    @Override
    public void computeSelection() {
        MenuManager menuManager = new ComputeInformations();
        menuManager.displayMainMenu();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        List<Double> totalIncome = new ArrayList<>();
        SortedMap<String, Double> purchasingList = new TreeMap<>();

        do {
            String userChoice = scanner.next();
            switch (userChoice){
                case "1":
                    System.out.println("\nEnter Income:");
                    totalIncome.add(scanner.nextDouble());
                    System.out.println("Income was added!\n");
                    menuManager.displayMainMenu();
                    break;
                case "2":
                    purchasingList.putAll(PurchasingInformations.purchasePerCategory(userChoice, purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "3":
                    System.out.println(PurchasingInformations.purchasePerCategory(userChoice, purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "4":
                    System.out.println(ComputeInformations.returnTotalIncome(totalIncome, purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "0":
                    System.out.print("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 4");
                    menuManager.displayMainMenu();
            }
        }while (!exit);
    }
}
