import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.BoundedThreadPool;
import org.mortbay.log.Log;

public class WebAppServer {
    public static void main(String[] args) {
	int port = 5005;
	if ( args.length >= 1 ) {
	    try {
		port = Integer.parseInt( args[0] );
	    }
	    catch( Exception ex ){ /*ignore*/ }
	}
	try {
	    //replace the default logger
	    Log.setLog( new LoggingAdapter(
		    java.util.logging.Logger.getLogger("jetty") ) );

	    Server server = new Server( port );
	    // set up a thread pool
	    BoundedThreadPool threadPool = new BoundedThreadPool();
	    threadPool.setMaxThreads( 100 );
	    server.setThreadPool(threadPool);

	    WebAppContext wac = new WebAppContext();
	    wac.setContextPath("/");
	    wac.setWar("webapp");

	    server.addHandler( wac );

	    server.setStopAtShutdown(true);
	    server.setSendServerVersion(true);
	    
	    server.start();
	    server.join();
	}
	catch( Exception ex ) {
	    Log.warn( ex );
	}
    }
}
