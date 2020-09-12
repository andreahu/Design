public class Ledger {

    String name;
    String description;
    String seed;

    public String createAccount(String accountId){
        Account newAccount = new Account(accountId);
        return newAccount.address;
    }

    public String processTransaction(Transaction transaction){

        try{
            // @TODO: 1
            // Validate the Transaction

            //@TODO: 2
            // add the Transaction to the current Block
            // and update the associated Account balances for the current Block

            return transaction.transactionId;
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
