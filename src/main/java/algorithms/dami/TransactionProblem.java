package algorithms.dami;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of Transactions (a transaction has one id, and one startAt which is a timestamp where  this transaction started, and
 * another timestamp endAt where this transaction ended)
 * <p>
 * Return the top N transactions with the longest durability.
 * <p>
 * Input:
 * transactions:[{startAt: 10; endAt:100}, {startAt: 50; endAt:90}, {startAt: 60; endAt:70}]
 * N : 2
 * Output:
 * [{startAt: 10; endAt:100}, {startAt: 50; endAt:90}]
 */
public class TransactionProblem {

    public List<Transaction> getLongestNTransactions(final int n, final List<Transaction> transactions) {
        if (n == 0) return Collections.emptyList();

        return transactions.stream()
                .sorted(Comparator.comparingLong(
                        (Transaction t) -> t.getEndedAt().toEpochMilli() - t.getStartedAt().toEpochMilli())
                        .reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

}

class Transaction {
    private final int id;
    private final Instant startedAt;
    private final Instant endedAt;

    public Transaction(final int id, final Instant startedAt, final Instant endedAt) {
        this.id = id;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public int getId() {
        return id;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Instant getEndedAt() {
        return endedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getId() == that.getId() &&
                getStartedAt().equals(that.getStartedAt()) &&
                getEndedAt().equals(that.getEndedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartedAt(), getEndedAt());
    }
}
