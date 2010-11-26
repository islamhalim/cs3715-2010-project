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

public class AccountServlet extends HttpServlet {
	public String[] courses;
	private String fullName;
	private String homeAddress;
	private String eMail;
	private String phoneNo;
	
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();

    	System.out.println("doPost is getting called!");

	if (path.equals("/account")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}

		out.println( "<?xml version='1.0'?>" );
		out.println( "<account>" );
		out.println( "<info>");
		out.println( "<realname>"+fullName+"</realname>");
		out.println( "<address>"+homeAddress+"</address>");
		out.println( "<email>"+eMail+"</email>");
		out.println( "<phone>"+phoneNo+"</phone>");
		out.println( "</info>");
		out.println( "<courses>");
		for (int i = 0; i < courses.length; i++){
			out.println( "<course>");
//			out.println("<name>" + courses.get(i).getName() + "</name>");
//			out.println("<number>" + courses.get(i).getNumber() + "</number>");
			out.println("</course>");
		}
		out.println ("</account>");
	}

    }
   

//   protected void doGet(
//        HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException
//    {
//        response.setContentType("text/xml");
//        PrintWriter out = response.getWriter();
//        String path = request.getPathInfo();
//	String letter = path;
//
//	System.out.println("doGet is getting called!");
//	System.out.println(letter);
//	
//	if (letter.equals("/root")){
//		System.out.println("Making it to login!");
//		out.print( "<?xml version='1.0'?>" );
//		out.print("<list>");			
//		out.print(username);
//		out.print(password);
//		out.print("</list>");
//	}

}
