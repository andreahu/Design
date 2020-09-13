import java.util.List;
import java.util.Map;

public class Block {

    int blockNumber;
    String previousHash;
    String hash;
    Block previousBlock;
    List<Transaction> transactionList;
    Map<String, Account> accountBalanceMap;
}
