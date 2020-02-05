package Budget_Manager.stage1;

/**
 * In this Project, we'll use the Strategy Design Pattern because it will be
 * easier to add new features for the next steps, without having to change completely the logic.
 *
 * Description - Stage 1:
 * First, let’s implement the counting of your purchases.
 * It’s much easier to analyze when your expenses are presented as a list.
 * Read data from the console and at the end show the list of all purchases and its total amount.
 *
 * It should be displayed as follows: Total: $23.00
 *
 * Your program should process every line the user inputs.
 * To end the input, the user should type End-of-file symbol that tells
 * your operating system that no more input will be provided.
 * It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows.
 *
 * Input:
 * Almond 250gm $35.43
 * LEGO DUPLO Town Farm Animals $10.10
 * Sensodyne Pronamel Toothpaste $19.74
 * Hershey's milk chocolate bars $8.54
 * Gildan LT $8.61
 *
 * Output:
 * Almond 250gm $35.43
 * LEGO DUPLO Town Farm Animals $10.10
 * Sensodyne Pronamel Toothpaste $19.74
 * Hershey's milk chocolate bars $8.54
 * Gildan LT $8.61
 *
 * Total: $82.42
 */

public interface BudgetManager {
    void totalSpent();
}

class BudgetManagerContext {
    private BudgetManager budgetManager;

    void setBudgetManager (BudgetManager budgetManager){
        this.budgetManager = budgetManager;
    }

    void totalSpent(){
        this.budgetManager.totalSpent();
    }
}

class Main {
    public static void main(String[] args) {
        BudgetManagerContext myBudgetManager = new BudgetManagerContext();

        // set the method that will be used for the budget management...
        myBudgetManager.setBudgetManager(new Budget_Manager.stage1.TotalSpent());
        myBudgetManager.totalSpent();
    }
}