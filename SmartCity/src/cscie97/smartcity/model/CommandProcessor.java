package cscie97.smartcity.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    ModelService modelService;

    public void processCommand(String command) throws CommandProcessorException {

        System.out.println("Processing command " + command);

        List<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find())
            list.add(m.group(1)); // Add .replace("\"", "") to remove surrounding quotes.

        // TODO: Add exception handling
        try {
            switch (list.get(0)) {
                case "create-ledger":

                    break;

                case "create-account":

                    break;

                case "process-transaction":

                    break;

                case "get-account-balance":

                    break;

                case "get-account-balances":

                    break;

                case "get-block":

                    break;

                case "get-transaction":

                    break;

                case "validate":

                    break;
            }
        } catch (CommandProcessorException e) {
            System.out.println(e.getMessage());
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
