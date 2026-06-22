public class LogLine {
    String abbreviation;
    String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
        this.abbreviation = logLine.substring(0, logLine.lastIndexOf("]") + 1);
    }

    public LogLevel getLogLevel() {
        return switch (abbreviation) {
            case ("[TRC]") -> LogLevel.TRACE;
            case ("[DBG]") -> LogLevel.DEBUG;
            case ("[INF]") -> LogLevel.INFO;
            case ("[WRN]") -> LogLevel.WARNING;
            case ("[ERR]") -> LogLevel.ERROR;
            case ("[FTL]") -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public String getOutputForShortLog() {
        String substring = logLine.substring(logLine.lastIndexOf(":")+2);
        return switch (abbreviation) {
            case ("[TRC]") -> "1:" + substring;
            case ("[DBG]") -> "2:" + substring;
            case ("[INF]") -> "4:" + substring;
            case ("[WRN]") -> "5:" + substring;
            case ("[ERR]") -> "6:" + substring;
            case ("[FTL]") -> "42:" + substring;
            default -> "0:" + substring;
        };
    }
}