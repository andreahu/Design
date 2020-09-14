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

        // Initialize genesis block.
        genesisBlock = new Block(1, null, new HashMap<String, Account>());
        genesisBlock.hash = genesisBlock.computeHash();
        this.blockMap.put(1, genesisBlock);


        // Initialize master account.
        Map<String, Account> accountMap = new HashMap<String, Account>();
        Account master = new Account("master");
        master.balance = Integer.MAX_VALUE;
        accountMap.put(master.address, master);

        // Initialize currentBlock.
        this.currentBlock = new Block(this.getNextBlockNumber(), genesisBlock, accountMap);
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

            this.currentBlock.hash = this.currentBlock.computeHash();
            this.blockMap.put(this.currentBlock.blockNumber, this.currentBlock);
            Block prevBlock = this.currentBlock;
            this.currentBlock = new Block(this.getNextBlockNumber(), prevBlock, clonedMap);
        }

        return transaction.transactionId;
    }

    public int getAccountBalance(String address) throws LedgerException{
        // Return the account for the Account with a given address
        if(currentBlock.previousBlock.accountBalanceMap.containsKey(address)){
            return currentBlock.previousBlock.accountBalanceMap.get(address).balance;
        }else{
            throw new LedgerException("getAccountBalance", "address doesn't exist");
        }
    }

    public Map<String, Integer> getAccountBalances(){
        Map<String, Integer> balances = new HashMap<>();
        for (Map.Entry<String, Account> entry : this.currentBlock.previousBlock.accountBalanceMap.entrySet()) {
            balances.put(entry.getKey(), entry.getValue().balance);
        }
        return balances;
    }

    public Transaction getTransaction(String transactionId){
        //Return the Transaction for the given transaction id.

        Iterator<Map.Entry<Integer, Block>> iterator = blockMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Block> entry = iterator.next();
            for (int i = 0; i < entry.getValue().transactionList.size(); i++) {
                if(entry.getValue().transactionList.get(i).transactionId == transactionId){
                    return entry.getValue().transactionList.get(i);
                }
            }
        }
        return null;
    }

    public Block getBlock(int number) {
        return this.blockMap.get(number);
    }



    public void validate() throws LedgerException {

        //Validate the current state of the blockchain. For each block, check the hash of the previous hash
        //TODO: what to check?
//        currentBlock.previousHash



        // make sure that the account balances total to the max value.
        //@TODO AH:
        //the design doc says "After a block is saved, the total value of all accounts in the account
        // balances map should equal the maximum possible account value of 2147483647"
        //However each block also only has 10 transactions. How to make sure the 10 transactions
        // totals to that number



        //Verify that each completed block has exactly 10 transactions.
        Iterator<Map.Entry<Integer, Block>> iterator = blockMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Block> entry = iterator.next();
            if(!entry.getValue().equals(currentBlock)){
                if(entry.getValue().transactionList.size() != 10){
                    throw new LedgerException("validate", "Unknown");
                }
            }
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
