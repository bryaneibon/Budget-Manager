package Budget_Manager.stage4;

/**
 * In this Project, we'll use the Strategy Design Pattern because it will be
 * easier to add new features for the next steps, without having to change completely the logic.
 *
 * Description - Stage 4:
 * What's the point of counting the money if the results are lost and
 * forgotten once you close the program? To allow for some long-term budget planning,
 * we need to save purchases to file. Add items Save and Load to the menu.
 *
 * Save should save all purchases to the file.
 * Load should load all purchases from the file.
 *
 * Use the purchases.txt file to store purchases.
 *
 * Example 1:::
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
 * 0) Exit
 * >1
 *
 * Enter income:
 * >1000
 * Income was added!
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
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
 * >Almond 250g
 * Enter its price:
 * >35.43
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
 * 5) Save
 * 6) Load
 * 0) Exit
 * >5
 *
 * Purchases were saved!
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
 * 0) Exit
 * >0
 *
 * Bye!
 *********************************
 * Example 2:::
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
 * 0) Exit
 * >6
 *
 * Purchases were loaded!
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
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
 * >1
 *
 * Food:
 * Almond 250g $35.43
 * Total sum: $35.43
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
 * Almond 250g $35.43
 * Total sum: $35.43
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
 * 5) Save
 * 6) Load
 * 0) Exit
 * >4
 *
 * Balance: $964.57
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 5) Save
 * 6) Load
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