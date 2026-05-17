package se.kth.iv1350.repairbike.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {

    private PrintWriter logStream;

    public FileLogger() {
        try {
            logStream = new PrintWriter(
                    new FileWriter("repair-log.txt", true), true);

        } catch (IOException exc) {
            System.out.println("Could not create log file.");
        }
    }

    public void log(String message) {
        if (logStream != null) {
            logStream.println(message);
        }
    }
}
