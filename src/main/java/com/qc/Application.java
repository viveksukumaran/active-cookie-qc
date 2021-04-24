package com.qc;

import com.qc.command.BaseCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@RequiredArgsConstructor
@SpringBootApplication(scanBasePackages = { "com.qc" })
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private final @NonNull IFactory factory;
    private final @NonNull BaseCommand command;
    private int exitCode;

    public static void main(final String[] args) {
        System.exit(SpringApplication
                .exit(new SpringApplicationBuilder(Application.class).logStartupInfo(false).run(args)));
    }

    @Override
    public void run(final String... args) {
        exitCode = new CommandLine(command, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
