package patterns.creational.builder;

public class BankAccountBuilder {
    private long accountNumber; //This is important, so we'll pass it to the constructor.
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    //Constructor is now private.
    private BankAccountBuilder(){
    }

    public static class Builder {
        private long accountNumber; //This is important, so we'll pass it to the constructor.
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        //By returning the builder each time, we can create a fluent interface.
        public Builder withOwner (String owner){
            this.owner = owner;
            return this;
        }

        public Builder atBranch (String branch){
            this.branch = branch;
            return this;
        }

        public Builder openingBalance (double balance){
            this.balance = balance;
            return this;
        }

        public Builder atRate (double interestRate){
            this.interestRate = interestRate;
            return this;
        }

        public BankAccountBuilder build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            BankAccountBuilder account = new BankAccountBuilder();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;
            return account;
        }
    }

    @Override
    public String toString() {
        return "BankAccountBuilder{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", branch='" + branch + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}
