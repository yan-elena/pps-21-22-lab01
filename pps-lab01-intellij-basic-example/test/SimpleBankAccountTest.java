import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testWithdraw() {
        final int depositAmount = 100;
        final int drawAmount = 70;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), drawAmount);
        assertEquals(depositAmount - drawAmount, bankAccount.getBalance());
    }
}
