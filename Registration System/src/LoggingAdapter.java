import java.util.logging.Level;
/**
 * Adapts sun's logger to the jetty package logger.
 */

public class LoggingAdapter implements org.mortbay.log.Logger {

    // copied from org.mortbay.log.StdErrLog
    private String format(String msg, Object arg0, Object arg1) {
	int i0=msg.indexOf("{}");
	int i1= i0 < 0 ? -1 : msg.indexOf("{}", i0+2);

	if (arg1!=null && i1>=0)
	    msg = msg.substring(0,i1)+arg1+msg.substring(i1+2);
	if (arg0!=null && i0>=0)
	    msg = msg.substring(0,i0)+arg0+msg.substring(i0+2);
	return msg;
    }

    private java.util.logging.Logger logger;
    private boolean debugEnabled;

    public LoggingAdapter ( java.util.logging.Logger logger ) {
	this.logger = logger;
	this.debugEnabled = false;
    }

    public void debug(String msg, Object arg0, Object arg1) {
        if ( debugEnabled ) {
	    logger.log( Level.FINEST, format(msg, arg0, arg1) );
	}
    }

    public void debug(String msg, Throwable th) {
        if ( debugEnabled ) {
	    logger.log( Level.FINEST, msg, th );
	}
    }

    public org.mortbay.log.Logger getLogger(String name) {
        return this;
    }

    public void info(String msg, Object arg0, Object arg1) {
	logger.log( Level.INFO, format(msg, arg0, arg1) );
    }

    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    public void setDebugEnabled(boolean enabled) {
        debugEnabled = enabled;
    }

    public void warn(String msg, Object arg0, Object arg1) {
	logger.log( Level.WARNING, format(msg, arg0, arg1) );
    }

    public void warn(String msg, Throwable th) {
	logger.log( Level.WARNING, msg, th );
    }
}
