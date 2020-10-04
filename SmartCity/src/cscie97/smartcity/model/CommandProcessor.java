package cscie97.smartcity.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {


    public void processCommand(String command) throws CommandProcessorException {

        ModelService modelService = new ModelService(new HashMap<String, City>(), new HashMap<String, Person>());

        System.out.println("Processing command " + command);

        List<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find())
            list.add(m.group(1)); // Add .replace("\"", "") to remove surrounding quotes.

        try {
            String theCommand = list.get(0) + " " + list.get(1);
            switch (theCommand) {
                case "define city":
                    if (list.size() != 13) {
                        throw new CommandProcessorException("defineCity", "wrong number of arguments", 0);
                    }
                    modelService.defineCity(list.get(2), list.get(4), list.get(6), Float.parseFloat(list.get(8)), Float.parseFloat(list.get(10)), Float.parseFloat(list.get(12)));
                    break;

                case "show city":
                    modelService.showCity(list.get(2));
                    break;

                case "define street-sign":
                    String cityDevice[] = list.get(2).split(":");//cityId=cityDevice[0]; deviceId=cityDevice[1]
                    modelService.defineStreetSign(cityDevice[0], cityDevice[1], )

                    break;

                case "update street-sign":

                    break;

                case "define info-kiosk":

                    break;

                case "update info-kiosk":

                    break;

                case "define street-light":

                    break;

                case "update street-light":

                    break;

                case "define parking-space":

                    break;

                case "update parking-space":

                    break;

                case "define robot":

                    break;

                case "update robot":

                    break;

                case "define vehicle":

                    break;

                case "update vehicle":

                    break;

                case "show device":

                    break;

                case "create sensor-event":

                    break;

                case "create sensor-output":

                    break;

                case "define resident":

                    break;

                case "update resident":

                    break;

                case "define visitor":

                    break;

                case "update visitor":

                    break;

                case "show person":

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
