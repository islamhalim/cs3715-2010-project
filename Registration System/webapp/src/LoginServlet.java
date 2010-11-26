import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;


/********************************************************************************
LoginServlet represents the servlet for handling logging into the Jetty server.


Author: James LaFreniere

********************************************************************************/

public class LoginServlet extends HttpServlet {
    private String username;
    private String password;
    private String status;
//    private LoginInterface login;

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();

    	System.out.println(path);
    	
	if (path.equals("/root")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}

		String noXMLString = sb.toString().replaceAll("\\<.*?\\>", "");
		System.out.println(noXMLString);
		String pass = noXMLString.substring(noXMLString.length() -8);
		String user = noXMLString.substring(0, (noXMLString.length() -8));
		username = user;
		password = pass;
//		Student s = login.Student(user, pass);
//		if (s == null) status = "bad";
//		else status = "ok";
		
		
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
