package algorithms.dami;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class TransactionProblemTest {

    @Test
    public void getLongestNTransactions() {
        TransactionProblem transactionProblem = new TransactionProblem();

        LocalDateTime date = LocalDateTime.of(2020, 5, 20, 10, 35);
        Instant instant1 = date.toInstant(ZoneOffset.UTC);
        LocalDateTime date2 = LocalDateTime.of(2020, 5, 20, 12, 35);
        Instant instant2 = date2.toInstant(ZoneOffset.UTC);
        Transaction t1 = new Transaction(1, instant1, instant2);

        LocalDateTime date3 = LocalDateTime.of(2020, 5, 20, 10, 35);
        Instant instant3 = date3.toInstant(ZoneOffset.UTC);
        LocalDateTime date4 = LocalDateTime.of(2020, 5, 20, 13, 35);
        Instant instant4 = date4.toInstant(ZoneOffset.UTC);
        Transaction t2 = new Transaction(2, instant3, instant4);

        LocalDateTime date5 = LocalDateTime.of(2020, 5, 20, 10, 35);
        Instant instant5 = date5.toInstant(ZoneOffset.UTC);
        LocalDateTime date6 = LocalDateTime.of(2020, 5, 20, 11, 35);
        Instant instant6 = date6.toInstant(ZoneOffset.UTC);
        Transaction t3 = new Transaction(3, instant5, instant6);

        List<Transaction> response = transactionProblem.getLongestNTransactions(1, Arrays.asList(t1,t2,t3));
        Assert.assertEquals(1, response.size());

        List<Transaction> expectedResponse = Arrays.asList(t2);
        Assert.assertArrayEquals(expectedResponse.toArray(), response.toArray());
    }
}