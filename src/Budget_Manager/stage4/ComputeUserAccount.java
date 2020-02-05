package Budget_Manager.stage4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                    Double income = scanner.nextDouble();
                    totalIncome.add(income);
                    System.out.println("Income was added!\n");

                    if (PurchasingInformations.purchasesFile.exists()) {
                        // Saved the balance (income) in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(PurchasingInformations.purchasesFile, true)) {
                            savedPurchases.write(ComputeInformations.returnTotalIncome(totalIncome, purchasingList));
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }
                    }
                    menuManager.displayMainMenu();
                    break;
                case "2":
                    purchasingList.putAll(PurchasingInformations.purchasePerCategory("2", purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "3":
                    System.out.println(PurchasingInformations.purchasePerCategory("3", purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "4":
                    System.out.println("\n" + ComputeInformations.returnTotalIncome(totalIncome, purchasingList));
                    menuManager.displayMainMenu();
                    break;
                case "5":
                    if (PurchasingInformations.purchasesFile.exists()) {
                        // Saved the balance (income) in purchases.txt file...
                        try (FileWriter savedPurchases = new FileWriter(PurchasingInformations.purchasesFile, true)) {
                            savedPurchases.write(ComputeInformations.returnTotalIncome(totalIncome, purchasingList));
                        } catch (IOException e) {
                            System.out.printf("An exception occurs %s", e.getMessage());
                        }
                        System.out.println("\nPurchases were saved!\n");
                    } else {
                        System.out.println("\nNothing to save!\n");
                    }
                    menuManager.displayMainMenu();
                    break;
                case "6":
                    File importedFile = new File(String.valueOf(PurchasingInformations.purchasesFile));
                    List<String> fileLoadedContent = new ArrayList<>();

                    try (Scanner fileScanner = new Scanner(importedFile)) {  // it throws FileNotFoundException (checked)
                        while (fileScanner.hasNextLine()) {
                            fileLoadedContent.add(fileScanner.nextLine());
                        }

                        //Loading balance (income).
                        double incomeLoaded = 0.0;
                        for (String s : fileLoadedContent) {
                            if (s.contains("Balance")) {
                                incomeLoaded = Double.parseDouble(s.substring(s.lastIndexOf("$") + 1));
                            }
                        }
                        totalIncome.add(incomeLoaded);

                        // Loading data.
                        ComputeInformations.dataPurchasedLoader(PurchasingInformations.categories, fileLoadedContent);
                    } catch (FileNotFoundException e) {
                        System.out.println("No file found: " + PurchasingInformations.purchasesFile);
                    } finally {
                        System.out.println("\nPurchases were loaded!\n");
                    }
                    menuManager.displayMainMenu();
                    break;
                case "0":
                    System.out.print("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown Command, choose between option 0 to 6");
                    menuManager.displayMainMenu();
            }
        }while (!exit);
    }
}
