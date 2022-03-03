import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    private static final int FEE = 1;

    @Override
    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testWithdraw() {
        final int depositAmount = 100;
        final int drawAmount = 70;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), drawAmount);
        assertEquals(depositAmount - drawAmount - FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawNotAllowed() {
        final int depositAmount = 100;
        final int drawAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositAmount);
        bankAccount.withdraw(accountHolder.getId(), drawAmount);
        assertEquals(depositAmount, bankAccount.getBalance());
    }
}