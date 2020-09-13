import java.util.Iterator;
import java.util.Map;

public class Ledger {

    String name;
    String description;
    String seed;

    Block genesisBlock;
    Map<Integer, Block> blockMap;

    //AH added
    Block currentBlock;

    public String createAccount(String accountId){
        Account newAccount = new Account(accountId);
        return newAccount.address;
    }

    public String processTransaction(Transaction transaction) throws LedgerException {


        if(transaction!= null){
            // add the Transaction to the current Block
            // and update the associated Account balances for the current Block
            currentBlock.transactionList.add(transaction);
            if(!currentBlock.accountBalanceMap.containsKey(transaction.receiver.address)){
                currentBlock.accountBalanceMap.put(transaction.receiver.address, transaction.receiver);
            }
            if(!currentBlock.accountBalanceMap.containsKey(transaction.payer.address)){
                currentBlock.accountBalanceMap.put(transaction.payer.address, transaction.payer);
            }
            return transaction.transactionId;
        }else{
            throw new LedgerException();
        }
    }

    public int getAccountBalance(String address) throws LedgerException{
        //Return the account balance for the Account with a given address
        if(currentBlock.accountBalanceMap.containsKey(address)){
            return currentBlock.accountBalanceMap.get(address).balance;
        }else{
            throw new LedgerException();
        }
    }

    public Map<String, Account> getAccountBalances(){

        //Return the account balance map for the most recent completed block.
        if(currentBlock.transactionList.size() == 10){
            return currentBlock.accountBalanceMap;
        }else{
            return currentBlock.previousBlock.accountBalanceMap;
        }

    }

    public int getTransaction(String transactionId){
        //@TODO: Return the Transaction for the given transaction id.

    }




    public void validate() throws LedgerException {

        //Validate the current state of the blockchain. For each block, check the
        //hash of the previous hash, make sure that the account balances total to the max value.
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
                    throw new LedgerException();
                }
            }
        }

    }




}
