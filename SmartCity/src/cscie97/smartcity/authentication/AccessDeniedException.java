package cscie97.smartcity.authentication;

import java.util.Formatter;

public class AccessDeniedException extends Throwable {
    String userId;
    String permissionId;

    public AccessDeniedException(String userId, String permissionId) {
        this.userId = userId;
        this.permissionId = permissionId;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        fmt.format("Access to permission %s is denied for user %s", this.permissionId, this.userId);
        return sb.toString();
    }
}
