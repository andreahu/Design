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
        while (m.find()) {// Add .replace("\"", "") to remove surrounding quotes.
            list.add(m.group(1));
        }

        String theCommand = list.get(0) + " " + list.get(1);
        String cityDevice[] = list.get(2).split(":");//when used, cityId=cityDevice[0]; deviceId=cityDevice[1]

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case "":

                    break;

                case "":

                    break;

                case "":

                    break;

                case "":

                    break;

                case "":

                    break;

                case "":

                    break;


            }
        }

        try {

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
                    modelService.defineStreetSign(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update street-sign":
                    modelService.updateStreetSign(cityDevice[0], cityDevice[1], list.get(4));
                    break;

                case "define info-kiosk":
                    modelService.defineKiosk(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update info-kiosk":
                    //@TODO: Optional parameter: enabled and imagelink
                    break;

                case "define street-light":
                    modelService.defineStreetLight(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update street-light":
                    //@TODO: Optional parameter: enabled and brightness
                    break;

                case "define parking-space":
                    modelService.defineParkingSpace(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update parking-space":
                    modelService.updateParkingSpace(cityDevice[0], cityDevice[1], list.get(4));
                    break;

                case "define robot":
                    modelService.defineRobot(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update robot":
                    //@TODO: Optional parameter: lat, lon, activity
                    break;

                case "define vehicle":
                    modelService.defineVehicle(cityDevice[0], cityDevice[1], Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10), list.get(12), list.get(14), list.get(16));
                    break;

                case "update vehicle":
                    //@TODO: Optional parameter: lat, lon, activity, enabled
                    break;

                case "show device":
                    if (cityDevice.length == 2) {
                        modelService.showDevice(cityDevice[0], cityDevice[1]);
                    } else {
                        modelService.showDevice(cityDevice[0]);
                    }
                    break;

                case "create sensor-event":
                    //@TODO: Optional parameter: subject

                    break;

                case "create sensor-output":
                    if (cityDevice.length == 2) {
                        modelService.createSensorOutput(cityDevice[0], cityDevice[1], list.get(4), list.get(6));
                    } else {
                        modelService.createSensorOutput(cityDevice[0], list.get(4), list.get(6));
                    }
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
