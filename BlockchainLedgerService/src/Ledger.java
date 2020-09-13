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

    public String processTransaction(Transaction transaction){

        try{
            if(transaction!= null){ //@TODO: can I use if else to catch exception?
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
            }
        } catch(LedgerException e){
            System.out.println("invalid transaction");
        }
    }

    public int getAccountBalance(String address){
        //@TODO: Return the account balance for the Account with a given address
        //AH: how to return an object by its attributes??

        return theAccount.address;

    }

    public int getAccountBalances(){

        //@TODO: Return the account balance map for the most recent completed block.
        //AH: how to know which block is the most recent completed?

    }

    public int getTransaction(String transactionId){
        //@TODO: Return the Transaction for the given transaction id.
    }




    public void validate(){



    }


}
