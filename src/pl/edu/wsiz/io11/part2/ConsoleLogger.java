package pl.edu.wsiz.io11.part2;

public class ConsoleLogger extends BaseLogger {
    public void info(String log) {
        System.out.println("INFO : " + log);
    }

    public void error(String log) {
        System.out.println("ERROR: " + log);
    }
}
