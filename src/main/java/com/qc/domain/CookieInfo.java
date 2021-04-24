package com.qc.domain;

import java.time.ZonedDateTime;
import lombok.Getter;

@Getter
public class CookieInfo {
    private final Cookie cookie;
    private final ZonedDateTime timestamp;
    
    public CookieInfo(final String cookieId, final String timestamp) {
        this.cookie = new Cookie(cookieId);
        this.timestamp = ZonedDateTime.parse(timestamp);
    }
}
