package Budget_Manager.stage1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TotalSpent implements BudgetManager {
    @Override
    public void totalSpent() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder outputSummary = new StringBuilder();
        StringBuilder purchases = new StringBuilder();

        do {
            String userInfos = scanner.nextLine();
            // Will take the user inputs.
            outputSummary.append(userInfos).append("\n");
            // Will only take the amount.
            purchases.append(outputSummary.substring(outputSummary.lastIndexOf("$") + 1)).append("\n");

        } while (scanner.hasNextLine());

        String [] purchasesList = purchases.toString().split("\n");

        System.out.println(outputSummary);
        System.out.println(returnAmountSpent(purchasesList));
    }

    private static String returnAmountSpent(String [] purchases){
        DecimalFormat staticDecimalFormat = new DecimalFormat("#.##");
        double result = 0.0;
        for (String value : purchases) {
            try{
                result = result + Double.parseDouble(value);
            } catch (NumberFormatException ignored){}
        }
        return "Total: $" + staticDecimalFormat.format(result);
    }
}
