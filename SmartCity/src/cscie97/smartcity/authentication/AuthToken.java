package cscie97.smartcity.authentication;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class AuthToken {
    private String token;
    private boolean isActive;
    private Date expirationTime;
    private String userId;

    public AuthToken(String userId) {
        this.userId = userId;

        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        this.token = new String(array, Charset.forName("UTF-8"));

        this.isActive = true;
        Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(7);
        this.expirationTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getToken() {
        return token;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public String getUserId() {
        return userId;
    }
}
