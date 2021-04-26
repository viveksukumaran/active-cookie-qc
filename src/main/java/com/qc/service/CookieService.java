package com.qc.service;

import com.qc.domain.Cookie;
import com.qc.domain.CookieInfo;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CookieService {

    /**
     * Find the most active cookies on a particular date
     * @param cookieInfo list of cookie timestamps
     * @param date the date on which cookie activity needs to be analyzed
     * @return the set of most active cookies
     */
    Set<Cookie> findMostActiveCookies(List<CookieInfo> cookieInfo, LocalDate date);

}
