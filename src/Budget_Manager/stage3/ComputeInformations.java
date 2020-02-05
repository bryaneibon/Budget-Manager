package Budget_Manager.stage3;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class ComputeInformations implements MenuManager {
    @Override
    public void displayPurchaseTypeMenu() {
        System.out.println("\nChoose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) Back");
    }

    @Override
    public void displayPurchaseTypeMenuAll() {
        System.out.println("\nChoose the type of purchases\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n" +
                "6) Back");
    }

    @Override
    public void displayMainMenu(){
        System.out.println("Choose your action:\n" +
                "1) Add income\n"                  +
                "2) Add purchase\n"                +
                "3) Show list of purchases\n"      +
                "4) Balance\n"                     +
                "0) Exit\n");
    }

    static void AddPurchase(SortedMap<String, Double> MapPerCategory, SortedMap<String, Double> completeMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter purchase name:");
        String item = itemName();
        System.out.println("Enter its price:");
        Double amount = scanner.nextDouble();
        MapPerCategory.put(item, amount);
        completeMap.putAll(MapPerCategory);
        System.out.println("Purchase was added!");
    }

    static void selectMenu(SortedMap<String, Double> finalPurchaseList){
        MenuManager menuManager = new ComputeInformations();
        if(finalPurchaseList.size() <= 1){
            menuManager.displayPurchaseTypeMenu();
        } else {
            menuManager.displayPurchaseTypeMenuAll();
        }
    }

    static String returnTotalIncome(List<Double> totalIncome, SortedMap<String, Double> purchase){
        double result = 0.00;
        for (double value : totalIncome) {
            result += value;
        }

        // If you already spent your money on something, we'll calculate the total here, then subtract this
        // total with your income.
        double total = 0;
        for (Map.Entry<String, Double> entry : purchase.entrySet()) {
            total += entry.getValue();
        }

        if (total != 0) {
            result -= total;
        }
        return "\nBalance: $" + String.format("%.2f", result) +"\n";
    }

    static String totalSpent(SortedMap<String, Double> purchase){
        double total = 0;
        for (Map.Entry<String, Double> entry : purchase.entrySet()) {
            total += entry.getValue();
        }

        if (total == 0){
            return "";
        } else{
            return "Total sum: $" + String.format("%.2f", total);
        }
    }

    static String itemName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static StringBuilder showPurchasesList(SortedMap<String, Double> purchase) {
        StringBuilder displayPurchaseList = new StringBuilder();

        if (purchase.isEmpty()) {
            displayPurchaseList.append("Purchase list is empty!\n");
        } else {
            // Get keys and values
            for (Map.Entry<String, Double> entry : purchase.entrySet()) {
                String doubleFormat = String.format("%.2f", entry.getValue());
                displayPurchaseList.append(entry.getKey()).append(" $").append(doubleFormat).append("\n");
            }
        }
        return displayPurchaseList;
    }
}