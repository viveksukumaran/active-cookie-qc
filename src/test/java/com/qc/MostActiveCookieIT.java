package com.qc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MostActiveCookieIT {
    @Autowired
    private CommandLineRunner cmdLine;

    @Test
    public void testRun() throws Exception {
        cmdLine.run("analyze", "-f", "logs/sample.csv", "-d", "2018-12-07");
    }
}
