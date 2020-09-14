import java.util.Formatter;

public class CommandProcessorException extends Throwable {

    String command;
    String reason;
    int lineNumber;

    public CommandProcessorException(String c, String r, int l) {
        this.command = c;
        this.reason = r;
        this.lineNumber = l;
    }

    public CommandProcessorException(String c, String r) {
        this(c, r, 0);
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        fmt.format("command: %s \nreason: %s\nlineNumber: %d", this.command, this.reason, this.lineNumber);
        return sb.toString();
    }
}
