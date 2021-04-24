package com.qc.command;

import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(
        subcommands = {
                UpdateCommand.class
        })
public class BaseCommand {
    // Add any common options here
}
