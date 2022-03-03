package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, it's an ATM Simple Bank Account, while for each withdrawal it requires a fee
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    protected int getFee() {
        return 1;
    }
}
