package cscie97.smartcity.controller;

import cscie97.smartcity.model.Event;

import java.util.ArrayList;


/**
 * Subject is an object having methods to attach and detach observers to a client object.
 */
public interface Subject {

    /**
     * Attach an observer object to the subject
     *
     * @param o: the observer object
     */
    public void attach(Observer o);

    /**
     * Detach an observer object to the subject
     *
     * @param o: the observer object
     */
    public void detach(Observer o);

    /**
     * Notify all the observers attached
     */
    public void notifyObservers();

    /**
     * Get the list of the events
     *
     * @return the list of the events
     */
    public ArrayList<Event> getEvents();

}
