package com.qc.service;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import com.qc.domain.CookieInfo;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

/**
 * Testing the log service
 */
public class LogServiceImplTest {
    private static final String VALID_LOG_FILE = "src/test/resources/test-logs.csv";
    private static final String INVALID_LOG_FILE = "./dummy.csv";
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenValidLogFileThenNonEmptyCookieInfoListIsReturned() throws Exception {
        final LogServiceImpl service = new LogServiceImpl();
        final List<CookieInfo> cookieLogs = service.readLogs(Paths.get(VALID_LOG_FILE));
        collector.checkThat("Logs must not be empty", cookieLogs, is(not(empty())));
    }

    @Test
    public void givenInValidLogFileThenExceptionIsThrown() throws Exception {
        final LogServiceImpl service = new LogServiceImpl();
        thrown.expect(IOException.class);
        service.readLogs(Paths.get(INVALID_LOG_FILE));
    }
}
