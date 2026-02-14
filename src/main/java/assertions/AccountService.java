// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package assertions;

/**
 * This class simulates a simple bank account service.
 *
 * It demonstrates how to use Java's "assert" keyword to validate assumptions
 * during program execution.
 *
 * Assertions are mainly used for debugging and testing.
 * They can be enabled/disabled at runtime using the JVM flag:
 *   -ea (enable assertions) or -da (disable assertions).
 */
public class AccountService {

    // Initial balance of the account.
    // This is the starting money in the account.
    private double balance = 1000.0;

    /**
     * This method allows withdrawing money from the account.
     *
     * Steps:
     * 1. Assert that the withdrawal amount is positive.
     * 2. If the amount is less than or equal to the balance, subtract it.
     * 3. Assert that the balance never drops below zero.
     *
     * @param amount - The amount of money to withdraw.
     */
    public void withdraw(double amount) {
        // Assertion #1: Withdrawal amount must be positive.
        // If someone tries to withdraw a negative or zero amount, this will fail.
        assert amount > 0 : "Withdrawal amount must be positive!";

        // Step 2: Check if there is enough balance to withdraw.
        if (amount <= balance) {
            balance -= amount; // Deduct the amount from balance.
        }

        // Assertion #2: Balance should never drop below zero.
        // If it does, something is wrong in the logic.
        assert balance > 0 : "System Error: Balance dropped zero!";
    }

    /**
     * This method returns the current balance in the account.
     *
     * @return balance - The remaining money in the account.
     */
    public double getBalance() {
        return balance;
    }
}