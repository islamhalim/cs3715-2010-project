import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;


/********************************************************************************
DataServlet represents the servlet for handling comments on the Jetty server.


Author: Robert Seward
Submitted To: Dr. Y. Chen
Date: Nov.21st, 2010

********************************************************************************/

public class LoginServlet extends HttpServlet {
    private String username;
    private String password;
    private String status;

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();

    	System.out.println("doPost is getting called!");
    	System.out.println(path);
    	
	if (path.equals("/root")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}

		username = sb.toString();
		System.out.println(username);
		//System.out.println( sb.toString() );
		out.println( "<?xml version='1.0'?>" );
		out.println("<login>");
		out.println( "<username> "+username+"</username>");
		out.println( "<password>"+password+"</password>");
		out.println( "<status>"+status+"</status>");
		out.println("</login>");
	}
	
	if (path.equals("/user")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}

		username = sb.toString();
		System.out.println(username);
		//System.out.println( sb.toString() );
		out.println( "<?xml version='1.0'?>" );
		out.println("<login>");
		out.println( "<username> "+username+"</username>");
		out.println( "<password>"+password+"</password>");
		out.println( "<status>"+status+"</status>");
		out.println("</login>");
	}
	
	if (path.equals("/new")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}
		System.out.println(sb.toString());
		out.println( "<?xml version='1.0'?>" );
		out.println("<login>");
		out.println( "<username> "+username+"</username>");
		out.println( "<password>"+password+"</password>");
		out.println( "<status>"+status+"</status>");
		out.println("</login>");
	}

    }

   protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();
	String letter = path;

	System.out.println("doGet is getting called!");
	System.out.println(letter);
	
	if (letter.equals("/root")){
		System.out.println("Making it to login!");
		out.println( "<?xml version='1.0'?>" );
		out.println("<login>");
		out.println( "<username> "+username+"</username>");
		out.println( "<password>"+password+"</password>");
		out.println( "<status>"+status+"</status>");
		out.println("</login>");
	}	
	
    }
}
