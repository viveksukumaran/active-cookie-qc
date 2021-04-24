package com.qc.service;

import static java.util.stream.Collectors.toList;

import com.qc.domain.CookieInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    private static final int HEADER = 1;
    private static final int NUM_COLUMNS = 2;
    private static final int ID = 0;
    private static final int TIMESTAMP = 1;

    @Override
    public List<CookieInfo> readLogs(final Path filePath) throws IOException {
        try (final Stream<String> lines = Files.lines(filePath)) {
            return lines
                    .skip(HEADER)
                    .map(line -> line.split(","))
                    .filter(cols -> cols.length == NUM_COLUMNS)
                    .map(cols -> new CookieInfo(cols[ID], cols[TIMESTAMP]))
                    .collect(toList());
        }
    }
}
