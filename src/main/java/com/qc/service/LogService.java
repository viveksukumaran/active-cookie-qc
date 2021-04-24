package com.qc.service;

import com.qc.domain.CookieInfo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface LogService {

    List<CookieInfo> readLogs(Path filePath) throws IOException;

}
