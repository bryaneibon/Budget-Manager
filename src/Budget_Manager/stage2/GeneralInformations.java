package Budget_Manager.stage2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

class GeneralInformations {
    static void displayMenu(){
        System.out.println("Choose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "0) Exit\n");
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

    static StringBuilder showPurchasesList(SortedMap<String, Double> purchase){
        StringBuilder displayPurchaseList = new StringBuilder();

        if (purchase.isEmpty()){
            displayPurchaseList.append("\nPurchase list is empty\n");
        } else {
            // Get keys and values
            for (Map.Entry<String, Double> entry : purchase.entrySet()) {
                String doubleFormat = String.format("%.2f", entry.getValue());
                displayPurchaseList.append(entry.getKey()).append(" $").append(doubleFormat).append("\n");
            }
        }
        return displayPurchaseList;
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
}
