class BankAccount {
    int balance;
    boolean open;

    void open() throws BankAccountActionInvalidException {
        if (!open) {
            balance = 0;
            open = true;
        }
        else {
            throw new BankAccountActionInvalidException("Account already open");
        }
    }

    void close() throws BankAccountActionInvalidException {
        if (open) {
            open = false;
        }
        else {
            throw new BankAccountActionInvalidException("Account not open");
        }
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        if (open) {
            return balance;
        }
        else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (open) {
            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            else {
                balance += amount;
            }
        }
        else {
            throw new BankAccountActionInvalidException("Account closed");
        }    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (open) {
            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            if (balance >= amount) {
                balance -= amount;
            }
            else {
                throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
            }
        }
        else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

}