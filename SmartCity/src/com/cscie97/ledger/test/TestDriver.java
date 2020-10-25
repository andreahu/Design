package com.cscie97.ledger.test;
import com.cscie97.ledger.*;

public class TestDriver {
    public static void main(String[] args) {
        CommandProcessor proc = new CommandProcessor();
        try {
            proc.processCommandFile(args[0]);
        } catch (CommandProcessorException e) {
            System.out.println(e.getMessage());
        }
    }
}
