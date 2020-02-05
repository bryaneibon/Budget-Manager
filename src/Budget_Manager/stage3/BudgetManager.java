package Budget_Manager.stage3;

/**
 * In this Project, we'll use the Strategy Design Pattern because it will be
 * easier to add new features for the next steps, without having to change completely the logic.
 *
 * Description - Stage 3:
 * To better control the expenses, we need to categorize our purchases.
 * It helps to see how exactly your budget is distributed: you may be actually quite surprised!
 *
 * Implement a function that assigns a purchase to a specific category.
 *
 * The program should have the following categories:
 * Food
 * Clothes
 * Entertainment
 * Other
 *
 * The function allows you to output the shopping list by type.
 * After selecting the action of showing the list of expenses,
 * offer to show either a certain category or a general list.
 * At the end print the total amount of purchases that are on the list.
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >3
 *
 * Purchase list is empty!
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >2
 *
 * Choose the type of purchase
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) Back
 * >1
 *
 * Enter purchase name:
 * >Milk
 * Enter its price:
 * >3.5
 * Purchase was added!
 *
 * Choose the type of purchase
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) Back
 * >5
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >3
 *
 * Choose the type of purchases
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) All
 * 6) Back
 * >4
 *
 * Other:
 * Purchase list is empty!
 *
 * Choose the type of purchases
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) All
 * 6) Back
 * >1
 *
 * Food:
 * Milk $3.50
 * Total sum: $3.50
 *
 * Choose the type of purchases
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) All
 * 6) Back
 * >5
 *
 * All:
 * Milk $3.50
 * Total sum: $3.50
 *
 * Choose the type of purchases
 * 1) Food
 * 2) Clothes
 * 3) Entertainment
 * 4) Other
 * 5) All
 * 6) Back
 * >6
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >0
 *
 * Bye!
 */

interface BudgetManager {
    void computeSelection();
}

class BudgetManagerContext {
    private BudgetManager budgetManager;

    void setBudgetManager (BudgetManager budgetManager){
        this.budgetManager = budgetManager;
    }

    void computeSelection(){
        this.budgetManager.computeSelection();
    }
}

class Main {
    public static void main(String[] args) {
        BudgetManagerContext myBudgetManager = new BudgetManagerContext();
        // set the method that will be used for the budget management (This step is mandatory)...
        myBudgetManager.setBudgetManager(new ComputeUserAccount());
        myBudgetManager.computeSelection();
    }
}