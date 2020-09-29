

import java.util.Formatter;

public class LedgerException extends Throwable {
    String action;
    String reason;

    public LedgerException(String a, String r) {
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
