public class Transaction {

    String transactionId;
    int amount;
    int fee;
    String note;

    Account payer;
    Account receiver;

    public Transaction(String transactionId, int amount, int fee, String note, Account payer, Account receiver){
        this.transactionId = transactionId;
        this.amount = amount;
        this.fee = fee;
        this.note = note;
        this.payer = payer;
        this.receiver = receiver;
    }


}
