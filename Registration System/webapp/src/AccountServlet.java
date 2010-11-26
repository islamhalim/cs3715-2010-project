import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList; 


/********************************************************************************
AccountServlet represents the servlet for retrieving and displaying account info
on the Jetty server.


Author: James LaFreniere

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

}
