import java.util.Locale;

public class LogLevels {
    
    public static String message(String logLine) {
        int number = logLine.indexOf(':');
        String message = logLine.substring(number+1);
        return message.trim();

    }

    public static String logLevel(String logLine) {
        String error = logLine.substring(1,logLine.indexOf(']'));
        return error.toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
