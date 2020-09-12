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
        
    }




    public void validate(){


    }


}
