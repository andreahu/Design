

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public String computeHash(String seed) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(seed.getBytes(StandardCharsets.UTF_8));
            for (Transaction t : this.transactionList) {
                digest.update(t.getSignature().getBytes(StandardCharsets.UTF_8));
            }
            byte[] hash = digest.digest();
            return Arrays.toString(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return "";
        }
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
