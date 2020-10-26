package cscie97.smartcity.controller;

import cscie97.smartcity.model.Event;

import java.util.ArrayList;

/**
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, its depenedent objects are to be notified automatically.
 * Observer monitors subject and update itself according to the events happen in subject
 */


public interface Observer {
    public void update();
}


