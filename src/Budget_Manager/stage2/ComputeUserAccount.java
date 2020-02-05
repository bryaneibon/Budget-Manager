package Budget_Manager.stage2;

import java.util.*;

public class ComputeUserAccount implements BudgetManager {
    @Override
    public void computeSelection() {
        GeneralInformations.displayMenu();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        List<Double> totalIncome = new ArrayList<>();
        SortedMap<String, Double> purchaseList = new TreeMap<>();

        do {
            String userChoice = scanner.next();
            switch (userChoice){
                case "1":
                    System.out.println("\nEnter Income:");
                    totalIncome.add(scanner.nextDouble());
                    System.out.println("Income was added!\n");
                    GeneralInformations.displayMenu();
                    break;
                case "2":
                    System.out.println("\nEnter purchase name:");
                    String item = GeneralInformations.itemName();
                    System.out.println("Enter its price:");
                    Double amount = scanner.nextDouble();
                    purchaseList.put(item, amount);
                    System.out.println("Purchase was added!\n");
                    GeneralInformations.displayMenu();
                    break;
                case "3":
                    System.out.println(GeneralInformations.showPurchasesList(purchaseList) +
                                       GeneralInformations.totalSpent(purchaseList));
                    GeneralInformations.displayMenu();
                    break;
                case "4":
                    System.out.println(GeneralInformations.returnTotalIncome(totalIncome, purchaseList));
                    GeneralInformations.displayMenu();
                    break;
                case "0":
                    System.out.print("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 4");
                    GeneralInformations.displayMenu();
            }
        }while (!exit);
    }
}
