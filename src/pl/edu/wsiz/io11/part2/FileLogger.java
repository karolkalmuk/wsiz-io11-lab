package pl.edu.wsiz.io11.part2;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends BaseLogger {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private PrintWriter writer;

    public FileLogger(String fileName) {
        try {
            FileOutputStream fileStream = new FileOutputStream(fileName, true);
            this.writer = new PrintWriter(fileStream, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void info(String message) {
        log("INFO ", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void log(String level, String message) {
        writer.printf("[%s] %s: %s\n", getCurrentDateString(), level, message);
    }

    private String getCurrentDateString() {
        Date now = new Date();
        return simpleDateFormat.format(now);
    }
}
