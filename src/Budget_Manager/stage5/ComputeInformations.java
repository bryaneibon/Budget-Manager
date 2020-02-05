package Budget_Manager.stage5;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
                "5) Save\n"                        +
                "6) Load\n"                        +
                "7) Analyze (Sort)\n"              +
                "0) Exit");
    }

    @Override
    public void sortingByTypeMenu() {
        System.out.println("\nHow do you want to sort?\n" +
                "1) Sort all purchases\n"                 +
                "2) Sort by type\n"                       +
                "3) Sort certain type\n"                  +
                "4) Back");
    }

    @Override
    public void sortingByCategoryMenu() {
        System.out.println("\nChoose the type of purchase\n" +
                "1) Food\n"                                  +
                "2) Clothes\n"                               +
                "3) Entertainment\n"                         +
                "4) Other");
    }

    static void AddPurchase(Map<String, Double> MapPerCategory, Map<String, Double> completeMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter purchase name:");
        String item = itemName();
        System.out.println("Enter its price:");
        Double amount = scanner.nextDouble();
        MapPerCategory.put(item, amount);
        completeMap.putAll(MapPerCategory);
        System.out.println("\nPurchase was added!");
    }

    static void selectMenu(Map<String, Double> finalPurchaseList){
        MenuManager menuManager = new ComputeInformations();
        if(finalPurchaseList.size() <= 1){
            menuManager.displayPurchaseTypeMenu();
        } else {
            menuManager.displayPurchaseTypeMenuAll();
        }
    }

    static String returnTotalIncome(List<Double> totalIncome, Map<String, Double> purchase){
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
        return "Balance: $" + String.format("%.2f", result) +"\n";
    }

    static String totalSpent(Map<String, Double> purchase){
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

    static StringBuilder showPurchasesList(Map<String, Double> purchase) {
        StringBuilder displayPurchaseList = new StringBuilder();

        if (purchase.isEmpty()) {
            displayPurchaseList.append("Purchase list is empty!");
        } else {
            // Get keys and values
            for (Map.Entry<String, Double> entry : purchase.entrySet()) {
                String doubleFormat = String.format("%.2f", entry.getValue());
                displayPurchaseList.append(entry.getKey()).append(" $").append(doubleFormat).append("\n");
            }
        }
        return displayPurchaseList;
    }

    static void dataPurchasedLoader(List<String> categories, List<String> fileLoadedContent){
        String itemPrice, itemName;
        for (String category : categories) {
            for (int i = 0; i < fileLoadedContent.size(); i++) {
                // Which means that we have a category match.
                if (fileLoadedContent.get(i).substring(0 ,fileLoadedContent.get(i).length()-1).equals(category)){
                    if (fileLoadedContent.get(i+1).contains("$") && !fileLoadedContent.get(i+1).contains(":")){
                        itemName = fileLoadedContent.get(i+1).replaceAll(" \\$.+", "").trim();
                        itemPrice = fileLoadedContent.get(i+1).substring(fileLoadedContent.get(i+1).lastIndexOf("$") + 1);
                        switch (category) {
                            case "Food":
                                PurchasingInformations.purchaseListFood.put(itemName, Double.parseDouble(itemPrice));
                                PurchasingInformations.purchaseListAll.putAll(PurchasingInformations.purchaseListFood);
                                break;
                            case "Clothes":
                                PurchasingInformations.purchaseListClothes.put(itemName, Double.parseDouble(itemPrice));
                                PurchasingInformations.purchaseListAll.putAll(PurchasingInformations.purchaseListClothes);
                                break;
                            case "Entertainment":
                                PurchasingInformations.purchaseListEntertainments.put(itemName, Double.parseDouble(itemPrice));
                                PurchasingInformations.purchaseListAll.putAll(PurchasingInformations.purchaseListEntertainments);
                                break;
                            case "Other":
                                PurchasingInformations.purchaseListOther.put(itemName, Double.parseDouble(itemPrice));
                                PurchasingInformations.purchaseListAll.putAll(PurchasingInformations.purchaseListOther);
                                break;
                        }
                    }
                }
            }
        }
    }
}