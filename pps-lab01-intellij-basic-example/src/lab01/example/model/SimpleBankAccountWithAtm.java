package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    protected int getFee() {
        return 1;
    }
}
