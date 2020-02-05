package Budget_Manager.stage5;

import java.util.*;
import static java.util.stream.Collectors.toMap;

public class BudgetAnalyzer extends PurchasingInformations {

    static void purchasesAnalyzer(){
        MenuManager menuManager = new ComputeInformations();
        menuManager.sortingByTypeMenu();

        boolean back = false;
        do {
            String sortType = scanner.next();
            switch (sortType){
                case "1":
                    StringBuilder emptyList = new StringBuilder("Purchase list is empty!");
                    StringBuilder checkPurchaseList = ComputeInformations.showPurchasesList(purchaseListAll);
                    if (emptyList.toString().equals(checkPurchaseList.toString())){
                        System.out.println("\n" + emptyList);
                    } else {
                        Map<String, Double> sortedFinalPurchaseList = sortByHighestValue(purchaseListAll);
                        System.out.println("\n" + categories.get(4) + ":\n" +
                                ComputeInformations.showPurchasesList(sortedFinalPurchaseList) +
                                ComputeInformations.totalSpent(sortedFinalPurchaseList));
                    }
                    menuManager.sortingByTypeMenu();
                    break;
                case "2":
                    System.out.println("\nTypes:");
                    System.out.println(categories.get(0) + " - " + expensesPerCategory(purchaseListFood));
                    System.out.println(categories.get(2) + " - " + expensesPerCategory(purchaseListEntertainments));
                    System.out.println(categories.get(1) + " - " + expensesPerCategory(purchaseListClothes));
                    System.out.println(categories.get(3) + " - " + expensesPerCategory(purchaseListOther));
                    System.out.println(ComputeInformations.totalSpent(purchaseListAll));
                    menuManager.sortingByTypeMenu();
                    break;
                case "3":
                    menuManager.sortingByCategoryMenu();
                    displayASortedCategory();
                    menuManager.sortingByTypeMenu();
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 5");
                    menuManager.sortingByTypeMenu();
            }
        }while (!back);
    }

    private static Map<String, Double> sortByHighestValue(Map<String, Double> unsortMap) {
        // Let's sort the map in decreasing order of value.
        return unsortMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

    static String expensesPerCategory(Map<String, Double> purchase){
        double total = 0;
        for (Map.Entry<String, Double> entry : purchase.entrySet()) {
            total += entry.getValue();
        }

        if (total == 0){
            return "Purchase list is empty!";
        } else{
            return "$" + String.format("%.2f", total);
        }
    }

    static void displayASortedCategory(){
        String typeSelected = scanner.next();
        Map<String, Double> sortedPurchaseList;
        switch (typeSelected){
            case "1":
                sortedPurchaseList = sortByHighestValue(purchaseListFood);
                System.out.println("\n" + categories.get(0) + ":\n" +
                        ComputeInformations.showPurchasesList(sortedPurchaseList) +
                        ComputeInformations.totalSpent(sortedPurchaseList));
                break;
            case "2":
                sortedPurchaseList = sortByHighestValue(purchaseListClothes);
                System.out.println("\n" + categories.get(1) + ":\n" +
                        ComputeInformations.showPurchasesList(sortedPurchaseList) +
                        ComputeInformations.totalSpent(sortedPurchaseList));
                break;
            case "3":
                sortedPurchaseList = sortByHighestValue(purchaseListEntertainments);
                System.out.println("\n" + categories.get(2) + ":\n" +
                        ComputeInformations.showPurchasesList(sortedPurchaseList) +
                        ComputeInformations.totalSpent(sortedPurchaseList));
                break;
            case "4":
                sortedPurchaseList = sortByHighestValue(purchaseListOther);
                System.out.println("\n" + categories.get(3) + ":\n" +
                        ComputeInformations.showPurchasesList(sortedPurchaseList) +
                        ComputeInformations.totalSpent(sortedPurchaseList));
                break;
            default:
                System.out.println("Unknown Command, choose between option 0 to 5");
        }
    }
}
