package cscie97.smartcity.controller;

import java.util.Formatter;

public class NoCommandException extends Throwable {
    String action;
    String reason;

    public NoCommandException(String a, String r) {
        this.action = a;
        this.reason = r;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        fmt.format("There is an error.\naction: %s \nreason: %s", this.action, this.reason);
        return sb.toString();
    }
}
