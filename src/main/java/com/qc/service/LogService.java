package com.qc.service;

import com.qc.domain.CookieInfo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface LogService {

    /**
     * Reads a log file and returns the list of cookie timestamps
     * @param filePath path of the log file
     * @return list of cookie information
     * @throws IOException if file cannot be read
     */
    List<CookieInfo> readLogs(Path filePath) throws IOException;

}
