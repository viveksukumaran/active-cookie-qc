package com.qc.service;

import com.qc.domain.Cookie;
import com.qc.domain.CookieInfo;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CookieService {

    Set<Cookie> findMostActiveCookies(List<CookieInfo> cookieInfo, LocalDate date);

}
