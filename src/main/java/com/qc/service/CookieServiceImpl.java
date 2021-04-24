package com.qc.service;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.qc.domain.Cookie;
import com.qc.domain.CookieInfo;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookieServiceImpl implements CookieService {

    @Override
    public Set<Cookie> findMostActiveCookies(final List<CookieInfo> cookieInfoList, final LocalDate date) {
        if (cookieInfoList == null || date == null) {
            return emptySet();
        }
        final Map<Cookie, Long> cookieCount = cookieInfoList.stream()
                .filter(info -> info.getTimestamp().toLocalDate().isEqual(date))
                .collect(groupingBy(CookieInfo::getCookie, counting()));
        return getMostActive(cookieCount);
    }

    private Set<Cookie> getMostActive(final Map<Cookie, Long> cookieCount) {
        long maxCount = 0;
        final Set<Cookie> result = new HashSet<>();
        for (final Map.Entry<Cookie, Long> entry : cookieCount.entrySet()) {
            final Cookie cookie = entry.getKey();
            final long count = entry.getValue();
            if (count == maxCount) {
                result.add(cookie);
            } else if (count > maxCount) {
                result.clear();
                result.add(cookie);
                maxCount = count;
            }
        }
        return result;
    }
}
