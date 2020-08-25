package patterns.creational.builder;

public class Main {

    public static void main (String[] args){
        BankAccountBuilder bankAccountBuilder = new BankAccountBuilder.Builder(1234L)
                .withOwner("Homer")
                .atBranch("Springfield")
                .openingBalance(1000L)
                .build();

        System.out.println(bankAccountBuilder.toString());
    }
}
