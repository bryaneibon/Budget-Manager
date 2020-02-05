package Budget_Manager.stage4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PurchasingInformations {
    static protected File purchasesFile = new File("./myFiles/purchases.txt"); // Prepare a recording file to save data.
    static protected List<String> categories = new ArrayList<>(Arrays.asList("Food", "Clothes", "Entertainment", "Other", "All"));
    static protected SortedMap<String, Double> purchaseListFood = new TreeMap<>();
    static protected SortedMap<String, Double> purchaseListClothes = new TreeMap<>();
    static protected SortedMap<String, Double> purchaseListEntertainments = new TreeMap<>();
    static protected SortedMap<String, Double> purchaseListOther = new TreeMap<>();
    static protected SortedMap<String, Double> purchaseListAll = new TreeMap<>();

    static SortedMap<String, Double> purchasePerCategory(String userSelection, SortedMap<String, Double> finalPurchaseList){
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        purchaseListAll.putAll(finalPurchaseList);
        ComputeInformations.selectMenu(finalPurchaseList);
        do {
            String typeSelected = scanner.next();
            switch (typeSelected){
                case "1":
                    if (userSelection.equals("2")){
                        ComputeInformations.AddPurchase(purchaseListFood, purchaseListAll);

                        // Saved Data in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(purchasesFile, true)) {
                            savedPurchases.write(categories.get(0) + ":\n" + ComputeInformations.showPurchasesList(purchaseListFood) + ComputeInformations.totalSpent(purchaseListFood) + "\n");
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }

                        ComputeInformations.selectMenu(purchaseListAll);
                    } else if (userSelection.equals("3")){
                        System.out.println("\n" + categories.get(0) + ":\n" + ComputeInformations.showPurchasesList(purchaseListFood) + ComputeInformations.totalSpent(purchaseListFood));
                        ComputeInformations.selectMenu(purchaseListAll);
                    }
                    break;
                case "2":
                    if (userSelection.equals("2")) {
                        ComputeInformations.AddPurchase(purchaseListClothes, purchaseListAll);

                        // Saved Data in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(purchasesFile, true)) {
                            savedPurchases.write(categories.get(1) + ":\n" + ComputeInformations.showPurchasesList(purchaseListClothes) + ComputeInformations.totalSpent(purchaseListClothes) + "\n");
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }

                        ComputeInformations.selectMenu(purchaseListAll);
                    } else if (userSelection.equals("3")){
                        System.out.println("\n" + categories.get(1) + ":\n" + ComputeInformations.showPurchasesList(purchaseListClothes) + ComputeInformations.totalSpent(purchaseListClothes));
                        ComputeInformations.selectMenu(purchaseListAll);
                    }
                    break;
                case "3":
                    if (userSelection.equals("2")) {
                        ComputeInformations.AddPurchase(purchaseListEntertainments, purchaseListAll);

                        // Saved Data in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(purchasesFile, true)) {
                            savedPurchases.write(categories.get(2) + ":\n" + ComputeInformations.showPurchasesList(purchaseListEntertainments) + ComputeInformations.totalSpent(purchaseListEntertainments) + "\n");
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }

                        ComputeInformations.selectMenu(purchaseListAll);
                    } else if (userSelection.equals("3")){
                        System.out.println("\n" + categories.get(2) + ":\n" + ComputeInformations.showPurchasesList(purchaseListEntertainments) + ComputeInformations.totalSpent(purchaseListEntertainments));
                        ComputeInformations.selectMenu(purchaseListAll);
                    }
                    break;
                case "4":
                    if (userSelection.equals("2")) {
                        ComputeInformations.AddPurchase(purchaseListOther, purchaseListAll);

                        // Saved Data in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(purchasesFile, true)) {
                            savedPurchases.write(categories.get(3) + ":\n" + ComputeInformations.showPurchasesList(purchaseListOther) + ComputeInformations.totalSpent(purchaseListOther) + "\n");
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }

                        ComputeInformations.selectMenu(purchaseListAll);
                    } else if (userSelection.equals("3")){
                        System.out.println("\n" + categories.get(3) + ":\n" + ComputeInformations.showPurchasesList(purchaseListOther) + ComputeInformations.totalSpent(purchaseListOther));
                        ComputeInformations.selectMenu(purchaseListAll);
                    }
                    break;
                case "5":
                    if(purchaseListAll.size() <= 1){
                        back = true;
                    }
                    else {
                        System.out.println("\n" + categories.get(4) + ":\n" + ComputeInformations.showPurchasesList(purchaseListAll) + ComputeInformations.totalSpent(purchaseListAll));

                        // Saved Data in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(purchasesFile, true)) {
                            savedPurchases.write(categories.get(4) + ":\n" + ComputeInformations.showPurchasesList(purchaseListAll) + ComputeInformations.totalSpent(purchaseListAll) + "\n");
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }

                        ComputeInformations.selectMenu(purchaseListAll);
                    }
                    break;
                case "6":
                    back = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 5");
                    ComputeInformations.selectMenu(purchaseListAll);
            }
        }while (!back);
        return purchaseListAll;
    }
}