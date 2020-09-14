import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ledger {

    String name;
    String description;
    String seed;

    Block genesisBlock;
    Map<Integer, Block> blockMap;

    //AH added
    private Block currentBlock;

    public Ledger(String name, String description, String seed){
        this.name = name;
        this.description = description;
        this.seed = seed;

        this.blockMap = new HashMap<Integer, Block>();
        this.genesisBlock = null;

        // Initialize master account.
        Map<String, Account> accountMap = new HashMap<String, Account>();
        Account master = new Account("master");
        master.balance = Integer.MAX_VALUE;
        accountMap.put(master.address, master);

        // Initialize currentBlock.
        this.currentBlock = new Block(this.getNextBlockNumber(), null, accountMap);
    }

    public String createAccount(String accountId){
        Account newAccount = new Account(accountId);
        this.currentBlock.accountBalanceMap.put(accountId, newAccount);
        return newAccount.address;
    }

    public String processTransaction(Transaction transaction) throws LedgerException {
        if (transaction == null) {
            throw new LedgerException("processTransaction", "Transaction can't be null");
        }
        if (transaction.amount + transaction.fee > transaction.payer.balance) {
            throw new LedgerException("processTransaction", "Payer doesn't have enough balance");
        }
        if (transaction.fee < 10) {
            throw new LedgerException("processTransaction", "Fee is less than minimum fee of $10");
        }
        currentBlock.transactionList.add(transaction);
        transaction.payer.balance = transaction.payer.balance - transaction.amount - transaction.fee;
        transaction.receiver.balance = transaction.receiver.balance + transaction.amount;
        this.getMasterAccount().balance += transaction.fee;


        // Commit the block if needed.
        if (this.currentBlock.transactionList.size() == 10) {
            Map<String, Account> clonedMap = new HashMap<>();
            for (Map.Entry<String, Account> entry : this.currentBlock.accountBalanceMap.entrySet()) {
                Account newAccount = new Account(entry.getValue().address, entry.getValue().balance);
                clonedMap.put(entry.getKey(), newAccount);
            }
            Block toBeCommitted = new Block(this.currentBlock.blockNumber, this.currentBlock.previousBlock, this.currentBlock.accountBalanceMap);
            toBeCommitted.transactionList = currentBlock.transactionList;
            toBeCommitted.hash = toBeCommitted.computeHash(this.seed);
            if (toBeCommitted.previousBlock == null) {
                this.genesisBlock = toBeCommitted;
            }

            this.blockMap.put(toBeCommitted.blockNumber, toBeCommitted);
            this.currentBlock = new Block(this.getNextBlockNumber(), toBeCommitted, clonedMap);
        }

        return transaction.transactionId;
    }

    public int getAccountBalance(String address) throws LedgerException{
        // Return the account for the Account with a given address
        if(currentBlock.previousBlock != null && currentBlock.previousBlock.accountBalanceMap.containsKey(address)){
            return currentBlock.previousBlock.accountBalanceMap.get(address).balance;
        }else{
            throw new LedgerException("getAccountBalance", "address doesn't exist");
        }
    }

    public Map<String, Integer> getAccountBalances(){
        Map<String, Integer> balances = new HashMap<>();
        if (this.currentBlock.previousBlock == null) {
            return balances;
        }
        for (Map.Entry<String, Account> entry : this.currentBlock.previousBlock.accountBalanceMap.entrySet()) {
            balances.put(entry.getKey(), entry.getValue().balance);
        }
        return balances;
    }

    public Transaction getTransaction(String transactionId){
        //Return the Transaction for the given transaction id.
        for (Map.Entry<Integer, Block> entry: this.blockMap.entrySet()) {
            Block b = entry.getValue();
            for (Transaction t : b.transactionList) {
                if (t.transactionId.equals(transactionId)) {
                    return t;
                }
            }
        }
        return null;
    }

    public Block getBlock(int number) {
        return this.blockMap.get(number);
    }

    public void validate() throws LedgerException {
        Block toBeValidated = this.currentBlock.previousBlock;
        String prevHash = this.currentBlock.previousHash;
        while (toBeValidated != null) {
            // Validates transaction size.
            if (toBeValidated.transactionList.size() != 10) {
                throw new LedgerException("validate", "Transaction count is not 10.");
            }

            // Validates account balances.
            int total = 0;
            for (Map.Entry<String, Account> entry : toBeValidated.accountBalanceMap.entrySet()) {
                total += entry.getValue().balance;
            }
            if (total != Integer.MAX_VALUE) {
                throw new LedgerException("validate", "Account balance has wrong total value:" + Integer.toString(total));
            }

            // Validate hash.
            String hash = toBeValidated.computeHash(seed);
            if (!hash.equals(toBeValidated.hash)) {
                throw new LedgerException("validate", "Wrong hash value");
            }

            // Validate previous hash.
            if (!prevHash.equals(hash)) {
                System.out.println(prevHash);
                System.out.println((hash));
                throw new LedgerException("validate", "Previous hash values don't match");
            }
            prevHash = toBeValidated.previousHash;
            toBeValidated = toBeValidated.previousBlock;
        }

    }

    public Account getAccount(String address) {
        if (this.currentBlock.accountBalanceMap.containsKey(address)) {
            return this.currentBlock.accountBalanceMap.get(address);
        } else {
            return null;
        }
    }

    private int getNextBlockNumber() {
        return this.blockMap.size() + 1;
    }

    private Account getMasterAccount() {
        return this.currentBlock.accountBalanceMap.get("master");
    }




}
