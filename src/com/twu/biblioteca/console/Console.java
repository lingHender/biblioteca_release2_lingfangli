package com.twu.biblioteca.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Console {
    private final BufferedReader reader;
    private final PrintStream printStream;

    public Console(BufferedReader reader, PrintStream printStream) {
        this.reader = reader;
        this.printStream = printStream;
    }

    public String getInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void print(String message) {
        printStream.print(message);
    }
}
