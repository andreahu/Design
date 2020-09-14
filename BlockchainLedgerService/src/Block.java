import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block {

    int blockNumber;
    String previousHash;
    String hash;
    Block previousBlock;

    List<Transaction> transactionList;
    Map<String, Account> accountBalanceMap;  //<accountID, account>

    public Block(int number, Block prev, Map<String, Account> accountMap) {
        this.blockNumber = number;
        this.previousBlock = prev;
        if (prev != null) {
            this.previousHash = prev.hash;
        }
        this.transactionList = new ArrayList<Transaction>();
        this.accountBalanceMap = accountMap;
    }

    public String computeHash() {
        // TODO: Implement the proper hash.
        return Integer.toString(this.hashCode());
    }

    @Override
    public String toString() {
        return
                "blockNumber=" + blockNumber +
                "\n previousHash='" + previousHash + '\'' +
                "\n hash='" + hash + '\'' +
                "\n transactionList=" + transactionList +
                "\n accountBalanceMap=" + accountBalanceMap +
                '}';
    }
}
