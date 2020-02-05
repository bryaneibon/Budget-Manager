package Budget_Manager.stage2;

/**
 * In this Project, we'll use the Strategy Design Pattern because it will be
 * easier to add new features for the next steps, without having to change completely the logic.
 *
 * Description - Stage 2:
 * Let's make your application more convenient. Only counting the expenses is a little bit sad, right?
 *
 * To make your application flexible and functional, add a menu that consists of 4 items.
 *
 * Add Income. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
 * Add Purchase. This item should add a purchase to the list. You have implemented this feature in the previous stage.
 * Show the list of purchases. This menu item should display a list of all expenses and incomes in the order they were made.
 * Balance. Show the balance.
 * Exit. Exit the program. Make this item under number 0, not number 5.
 * Notice, that the amount of remaining money cannot be negative. In this case, make the balance equal to $0.
 *
 * When displaying the price or the total amount, print 2 numbers after the point.
 * Example: $14.20
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
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
 * 0) Exit
 * >4
 *
 * Balance: $1000.00
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >3
 *
 * Purchase list is empty
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >2
 *
 * Enter purchase name:
 * >Red Fuji Apple
 * Enter its price:
 * >5.99
 * Purchase was added!
 *
 * Choose your action:
 * 1) Add income
 * 2) Add purchase
 * 3) Show list of purchases
 * 4) Balance
 * 0) Exit
 * >3
 *
 * Red Fuji Apple $5.99
 * Total sum: $5.99
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