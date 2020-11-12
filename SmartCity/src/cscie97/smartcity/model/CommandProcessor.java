package cscie97.smartcity.model;

import com.cscie97.ledger.Ledger;
import cscie97.smartcity.authentication.AuthenticationService;
import cscie97.smartcity.controller.ControllerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {

    public static float FLOAT_EMPTY = Float.MAX_VALUE;
    ModelService modelService;
    ControllerService controller;
    AuthenticationService authenticationService;
    private Ledger ledger;

    public CommandProcessor() {
        this.ledger = new Ledger("ControllerLedger", "the ledger used for controllerService", "AH");
        this.modelService = new ModelService(new HashMap<String, City>(), new HashMap<String, Person>(), this.ledger);
        this.controller = new ControllerService(modelService, this.ledger);
        this.authenticationService = new AuthenticationService();
    }

    private List<String> stripQuotes(List<String> in) {
        List<String> out = new ArrayList<>();
        for (String s : in) {
            if (s.startsWith("\"") && s.endsWith("\"")) {
                out.add(s.substring(1, s.length() - 1));
            } else {
                out.add(s);
            }
        }
        return out;
    }

    public void processCommand(String command) throws CommandProcessorException {

        System.out.println("Processing command " + command);

        List<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find()) {// Add .replace("\"", "") to remove surrounding quotes.
            list.add(m.group(1));
        }
        list = this.stripQuotes(list);

        String theCommand = list.get(0) + " " + list.get(1);
        String authenticationCommand = list.get(0);
        String[] cityDevicePair = list.get(2).split(":");
        String city_id = null;
        String device_id = null;
        if (cityDevicePair.length == 2) {
            city_id = cityDevicePair[0];
            device_id = cityDevicePair[1];
        }

        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("bio-metric", null);
        map.put("phone", null);
        map.put("role", null);
        map.put("lat", null);
        map.put("long", null);
        map.put("account", null);
        map.put("enabled", null);
        map.put("image", null);
        map.put("brightness", null);
        map.put("activity", null);
        map.put("fee", null);
        map.put("subject", null);
        map.put("type", null);
        map.put("value", null);

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), list.get(i + 1));
            }
        }

        String name = map.get("name");
        String bio_metric = map.get("bio-metric");
        String phone = map.get("phone");
        String role = map.get("role");
        String account = map.get("account");
        String enabled = map.get("enabled");
        String image = map.get("image");
        String brightness = map.get("brightness");
        String activity = map.get("activity");
        String fee = map.get("fee");
        String subject = map.get("subject");
        String type = map.get("type");
        String value = map.get("value");

        String latString = map.get("lat");
        float lat = FLOAT_EMPTY;
        if (latString != null) {
            lat = Float.parseFloat(latString);
        }
        String lonString = map.get("long");
        float lon = FLOAT_EMPTY;
        if (lonString != null) {
            lon = Float.parseFloat(lonString);
        }


        try {

            switch (theCommand) {
                case "define city":
                    if (list.size() != 13) {
                        throw new CommandProcessorException("defineCity", "wrong number of arguments", 0);
                    }
                    this.modelService.defineCity(list.get(2), list.get(4), list.get(6), Float.parseFloat(list.get(8)), Float.parseFloat(list.get(10)), Float.parseFloat(list.get(12)));
                    break;

                case "show city":
                    this.modelService.showCity(list.get(2));
                    break;

                case "define street-sign":
                    this.modelService.defineStreetSign(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update street-sign":
                    this.modelService.updateStreetSign(city_id, device_id, list.get(4));
                    break;

                case "define info-kiosk":
                    this.modelService.defineKiosk(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update info-kiosk":
                    this.modelService.updateKiosk(city_id, device_id, enabled, brightness);
                    break;

                case "define street-light":
                    this.modelService.defineStreetLight(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update street-light":
                    this.modelService.updateStreetLight(city_id, device_id, enabled, image);
                    break;

                case "define parking-space":
                    this.modelService.defineParkingSpace(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), Integer.parseInt(list.get(10)));
                    break;

                case "update parking-space":
                    this.modelService.updateParkingSpace(city_id, device_id, Integer.parseInt(list.get(4)));
                    break;

                case "define robot":
                    this.modelService.defineRobot(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10));
                    break;

                case "update robot":
                    this.modelService.updateRobot(city_id, device_id, lat, lon, activity);
                    break;

                case "define vehicle":
                    this.modelService.defineVehicle(city_id, device_id, Float.parseFloat(list.get(4)), Float.parseFloat(list.get(6)), list.get(8), list.get(10), list.get(12), list.get(14), Integer.parseInt(list.get(16)), ledger);
                    break;

                case "update vehicle":
                    this.modelService.updateVehicle(city_id, device_id, lat, lon, enabled, activity);
                    break;

                case "show device":
                    if (cityDevicePair.length == 2) {
                        this.modelService.showDevice(city_id, device_id);
                    } else {
                        this.modelService.showDevice(list.get(2));
                    }
                    break;

                case "create sensor-event":
                    this.modelService.createSensorEvent(city_id, device_id, map.get("type"), map.get("value"), map.get("subject"));
                    break;

                case "create sensor-output":
                    if (cityDevicePair.length == 2) {
                        this.modelService.createSensorOutput(city_id, device_id, list.get(4), list.get(6));
                    } else {
                        this.modelService.createSensorOutput(list.get(2), list.get(4), list.get(6));
                    }
                    break;

                case "define resident":
                    this.modelService.defineResident(list.get(2), name, bio_metric, phone, role, lat, lon, account);
                    break;

                case "update resident":
                    this.modelService.updateResident(list.get(2), name, bio_metric, phone, role, lat, lon, account);
                    break;

                case "define visitor":
                    this.modelService.defineVisitor(list.get(2), bio_metric, lat, lon);
                    break;

                case "update visitor":
                    this.modelService.updateVisitor(list.get(2), bio_metric, lat, lon);
                    break;

                case "show person":
                    this.modelService.showPerson(list.get(2));
                    break;
            }

            switch (authenticationCommand) {
                case "define_permission":
                    this.authenticationService.definePermission(list.get(1), list.get(2), list.get(3));
                    break;

                case "define_role":
                    this.authenticationService.defineRole(list.get(1), list.get(2), list.get(3));
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
