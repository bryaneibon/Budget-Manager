# Budget-Manager
Design a Budget Manager to Track our recurring expenses and the categories of expenses that influence our income.

 * Description - Stage 1:
 First, let’s implement the counting of your purchases.
 It’s much easier to analyze when your expenses are presented as a list.
 Read data from the console and at the end show the list of all purchases and its total amount. (Look at BudgetManager.java for more details)


 * Description - Stage 2:
 Let's make your application more convenient. Only counting the expenses is a little bit sad, right?
 To make your application flexible and functional, add a menu that consists of 4 items.
 -) Add Income. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
 
 -) Add Purchase. This item should add a purchase to the list. You have implemented this feature in the previous stage.
 
 -) Show the list of purchases. This menu item should display a list of all expenses and incomes in the order they were made.
 
 -) Balance. Show the balance.
 
 -) Exit. Exit the program. Make this item under number 0, not number 5.
 Notice, that the amount of remaining money cannot be negative. In this case, the balance equal to $0.(Look at BudgetManager.java for more details)


  * Description - Stage 3:
 To better control the expenses, we need to categorize our purchases. It helps to see how exactly your budget is distributed. The function allows you to output the shopping list by type. After selecting the action of showing the list of expenses, offer to show either a certain category or a general list. At the end print the total amount of purchases that are on the list. (Look at BudgetManager.java for more details)


 * Description - Stage 4:
 What's the point of counting the money if the results are lost and forgotten once you close the program?
 To allow for some long-term budget planning, we need to save purchases to file. Add items Save and Load to the menu.
 
 -) Save should save all purchases to the file.
 
 -) Load should load all purchases from the file.
 
 -) We used a purchases.txt file to store purchases. (Look at BudgetManager.java for more details)


 * Description - Stage 5:
  Do you know how much money you spend on food? On entertainment? It's quite interesting to know since the main purpose of this application is to analyze your expenses. Let's implement this feature!
 First, add the Analyze item to the menu. This way you will request an analysis of your purchases. Once this item is called you need to offer a way to sort the purchases. (Look at BudgetManager.java for more details)