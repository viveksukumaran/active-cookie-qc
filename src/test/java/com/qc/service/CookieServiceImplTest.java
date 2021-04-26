package com.qc.service;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.qc.domain.Cookie;
import com.qc.domain.CookieInfo;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Testing the cookie service
 */
public class CookieServiceImplTest {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenEmptyCookieInfoWhenMostActiveIsRequestedThenEmptySetIsReturned() {
        final CookieServiceImpl service = new CookieServiceImpl();
        final Set<Cookie> result = service.findMostActiveCookies(null, LocalDate.now());
        collector.checkThat("Result must be empty", result, is(empty()));
    }

    @Test
    public void givenNullDateWhenMostActiveIsRequestedThenEmptySetIsReturned() {
        final CookieServiceImpl service = new CookieServiceImpl();
        final Set<Cookie> result = service.findMostActiveCookies(getCookieInfo(), null);
        collector.checkThat("Result must be empty", result, is(empty()));
    }

    @Test
    public void givenCookieInfoWhenMostActiveIsRequestedThenNonEmptySetIsReturned() {
        final CookieServiceImpl service = new CookieServiceImpl();
        final Set<Cookie> result = service.findMostActiveCookies(getCookieInfo(), LocalDate.parse("2018-12-09"));
        collector.checkThat("Result must be empty", result.iterator().next(),
                is(equalTo(new Cookie("AtY0laUfhglK3lC7"))));
    }

    private List<CookieInfo> getCookieInfo() {
        return Arrays.asList(
                new CookieInfo("AtY0laUfhglK3lC7", "2018-12-09T14:19:00+00:00"),
                new CookieInfo("SAZuXPGUrfbcn5UA", "2018-12-09T10:13:00+00:00"),
                new CookieInfo("AtY0laUfhglK3lC7", "2018-12-09T06:19:00+00:00"));
    }
}
