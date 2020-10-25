package com.cscie97.ledger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    Ledger ledger;

    public void processCommand(String command) throws CommandProcessorException{

        System.out.println("Processing command " + command);

        List<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find())
            list.add(m.group(1)); // Add .replace("\"", "") to remove surrounding quotes.

        // TODO: Add exception handling
        try {
            switch (list.get(0)) {
                case "create-ledger":
                    if (list.size() != 6) {
                        throw new CommandProcessorException("create-ledger", "wrong number of arguments", 0);
                    }
                    this.ledger = new Ledger(list.get(1), list.get(3), list.get(5));
                    System.out.println("Ledge created");
                    break;

                case "create-account":
                    String accountID = ledger.createAccount(list.get(1));
                    System.out.println("account created for " + accountID);
                    break;

                case "process-transaction":
                    int amount = Integer.parseInt(list.get(3));
                    int fee = Integer.parseInt(list.get(5));
                    Account payer = ledger.getAccount(list.get(9));
                    Account receiver = ledger.getAccount(list.get(11));
                    Transaction transaction = new Transaction(list.get(1), amount, fee, list.get(7), payer, receiver);
                    String transactionId = ledger.processTransaction(transaction);
                    System.out.println("transaction processed for transactionID: " + transactionId);
                    break;

                case "get-account-balance":
                    int balance = ledger.getAccountBalance(list.get(1));
                    System.out.println("Account balance is: " + balance);
                    break;

                case "get-account-balances":
                    Map<String, Integer> map = ledger.getAccountBalances();
                    if (map.isEmpty()) {
                        System.out.println("There is no balances to display.");
                    } else {
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println("Address: " + entry.getKey() + ", Balance: " + Integer.toString(entry.getValue()));
                        }
                    }
                    break;
                case "get-block":
                    if (list.size() < 1) {
                        throw new CommandProcessorException("get-block", "not enough arguments");
                    }
                    int blockId = Integer.parseInt(list.get(1));
                    Block block = ledger.getBlock(blockId);
                    System.out.println(block.toString());
                    break;

                case "get-transaction":
                    Transaction transaction1 = ledger.getTransaction(list.get(1));
                    if (transaction1 != null) {
                        System.out.println("Transaction detail: amount: " + transaction1.amount + " fee: " + transaction1.fee + "note: " + transaction1.note + " payer: " + transaction1.payer.address + " receiver: " + transaction1.receiver.address);
                    } else {
                        System.out.println("No transaction found.");
                    }
                    break;

                case "validate":
                    ledger.validate();
                    System.out.print("The blockchain is valid.");
                    break;
            }
        } catch (LedgerException l) {
            System.out.println(l.getMessage());
        }
    }

    public void processCommandFile(String commandFile) throws CommandProcessorException {
        int lineNumber = 0;
        try {
            File file = new File(commandFile);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.startsWith("#") && !data.isEmpty()) {
                    this.processCommand(data);
                }
                lineNumber++;
            }
            myReader.close();
        } catch (CommandProcessorException e) {
            throw new CommandProcessorException(e.command, e.reason, lineNumber);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }
    }

}
