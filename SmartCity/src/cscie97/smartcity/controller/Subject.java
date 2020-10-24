package cscie97.smartcity.controller;

import cscie97.smartcity.model.Event;

import java.util.ArrayList;

public interface Subject {


    public void attach(Observer o);

    public void detach(Observer o);

    public void notifyObservers();

    public ArrayList<Event> getEvents();

}
