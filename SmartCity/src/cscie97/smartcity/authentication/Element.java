package cscie97.smartcity.authentication;

import cscie97.smartcity.model.Visitor;

public interface Element {
    /**
     * interface to accepting vistors
     */

    public void accept(VisitorINF v);

}
