package com.qc.command;

import com.qc.domain.CookieInfo;
import com.qc.service.CookieService;
import com.qc.service.LogService;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name = "analyze")
@RequiredArgsConstructor
class UpdateCommand implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(UpdateCommand.class);

    private final CookieService cookieService;
    private final LogService logService;
    @Option(names = { "-f", "--log-file" }, description = "Path of log file", required = true)
    private Path logFilePath;
    @Option(names = { "-d", "--date" }, description = "Date to search for cookies", required = true)
    private LocalDate date;

    @Override
    public Integer call() {
        try {
            final List<CookieInfo> cookieInfo = logService.readLogs(logFilePath);
            cookieService.findMostActiveCookies(cookieInfo, date).forEach(cookie -> System.out.println(cookie.getId()));
            return 0;
        } catch (final IOException e) {
            logger.error("Failed to read log file", e);
            return 1;
        }
    }
}
