// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package assertions;

// Importing JUnit 5 annotations and assertions.
// These are used to write and run unit tests.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the AccountService class.
 *
 * Unit tests are small, automated checks that verify if methods
 * in your code behave as expected.
 *
 * @DisplayName("Bank Account Testing")
 * - This gives a human-readable name to the test class.
 * - It makes test reports easier to understand.
 */
@DisplayName("Bank Account Testing")
public class AccountServiceTest {

    // Declare a variable for AccountService.
    AccountService service;

    /**
     * @BeforeEach:
     * - This method runs before each test case.
     * - It sets up a fresh AccountService object so tests don’t interfere with each other.
     */
    @BeforeEach
    void setup() {
        service = new AccountService();
    }

    /**
     * @Test:
     * - Marks this method as a test case.
     *
     * @DisplayName("Verified Success Withdrawal")
     * - Gives a readable name to this test.
     *
     * This test checks if withdrawing 200 from the account works correctly.
     * Expected behavior:
     * - Balance should reduce from 1000 → 800.
     */
    @Test
    @DisplayName("Verified Success Withdrawal")
    void testWithdrawSuccess() {
        service.withdraw(200);

        // Assert that the balance is now 800.
        // If not, the test will fail with the given message.
        assertEquals(800.0, service.getBalance(), "Balance should be 800 after withdrawing 200");
    }

    /**
     * This test checks multiple conditions at once using assertAll.
     *
     * Steps:
     * 1. Withdraw 100 from the account.
     * 2. Verify multiple things:
     *    - Balance should be 900.
     *    - Balance should still be positive.
     *    - The service object should not be null.
     */
    @Test
    @DisplayName("Verify Multiple Conditions")
    void testMultipleAssertion() {
        service.withdraw(100);

        // assertAll allows grouping multiple assertions together.
        // If one fails, the others are still checked.
        assertAll("Account State Check",
                () -> assertEquals(900.0, service.getBalance()),   // Balance check
                () -> assertTrue(service.getBalance() > 0),        // Positive balance check
                () -> assertNotNull(service)                       // Service object should not be null
        );
    }
}