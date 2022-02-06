package pl.edu.wsiz.io11.part2;

public class MultiLogger implements Logger {
    private Logger[] loggers;

    public MultiLogger(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void info(String log) {
        for (Logger logger : loggers) {
            logger.info(log);
        }
    }

    public void error(String log) {
        for (Logger logger : loggers) {
            logger.error(log);
        }
    }
}
