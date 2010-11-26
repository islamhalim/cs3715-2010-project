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

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String path = request.getPathInfo();

    	System.out.println("doPost is getting called!");

	if (path.equals("/root")){
		System.out.println("path=" + path );	
		BufferedReader rd = request.getReader();
		StringBuilder sb = new StringBuilder();
		int ch;
		while ( (ch=rd.read()) != -1 ) {
		    sb.append( (char)ch);
		}

	
		username = sb.toString();
	
		//System.out.println( sb.toString() );
		out.println( "<?xml version='1.0'?>" );
		out.print( "<list>" );
		out.print( "<element> username"+username+"</element>");
		out.print( "<element> password"+password+"</element>");
		out.print ( username + "</list>");
		
//		countA++;
	}

//	if (path.equals("/b")){
//		System.out.println("path=" + path );	
//		BufferedReader rd = request.getReader();
//		StringBuilder sb = new StringBuilder();
//		int ch;
//		while ( (ch=rd.read()) != -1 ) {
//		    sb.append( (char)ch);
//		}
//
//	
//		pictureB.add(sb.toString());
//	
//		//System.out.println( sb.toString() );
//		out.println( "<?xml version='1.0'?>" );
//		out.print( "<list>" );
//		//out.print( "<element> count"+count+"</element>");
//		//out.print ( sb.toString() + "</list>" );
//		out.print ( pictureB.get(countB) + "</list>");	
//		countB++;
//	}
//
//	if (path.equals("/c")){
//		System.out.println("path=" + path );	
//		BufferedReader rd = request.getReader();
//		StringBuilder sb = new StringBuilder();
//		int ch;
//		while ( (ch=rd.read()) != -1 ) {
//		    sb.append( (char)ch);
//		}
//
//	
//		pictureC.add(sb.toString());
//	
//		//System.out.println( sb.toString() );
//		out.println( "<?xml version='1.0'?>" );
//		out.print( "<list>" );
//		//out.print( "<element> count"+count+"</element>");
//		//out.print ( sb.toString() + "</list>" );
//		out.print ( pictureC.get(countC) + "</list>");	
//		countC++;
//	}
//
//	if (path.equals("/d")){
//		System.out.println("path=" + path );	
//		BufferedReader rd = request.getReader();
//		StringBuilder sb = new StringBuilder();
//		int ch;
//		while ( (ch=rd.read()) != -1 ) {
//		    sb.append( (char)ch);
//		}
//
//	
//		pictureD.add(sb.toString());
//	
//		//System.out.println( sb.toString() );
//		out.println( "<?xml version='1.0'?>" );
//		out.print( "<list>" );
//		//out.print( "<element> count"+count+"</element>");
//		//out.print ( sb.toString() + "</list>" );
//		out.print ( pictureD.get(countD) + "</list>");	
//		countD++;
//	}
//
//
//

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
		out.print( "<?xml version='1.0'?>" );
		out.print("<list>");			
		out.print(username);
		out.print(password);
		out.print("</list>");
	}

//	if (letter.equals("B/Bcomment")){
//		System.out.println("Making it to B!");        
//		out.print( "<?xml version='1.0'?>" );
//		out.print("<list>");		
//		for (int i=0; i<countB; i++){
//			out.print(pictureB.get(i));		
//		}
//		out.print("</list>");
//	}
//
//	if (letter.equals("C/Ccomment")){
// 		System.out.println("Making it to C!");
//		out.print( "<?xml version='1.0'?>" );
//		out.print("<list>");		
//		for (int i=0; i<countC; i++){
//			out.print(pictureC.get(i));
//		}
//		out.print("</list>");
//	}
//
//	if (letter.equals("D/Dcomment")){
//		System.out.println("Making it to D!");
//		out.print( "<?xml version='1.0'?>" );
//		out.print("<list>");		
//		for  (int i=0; i<countD; i++){
//			out.print(pictureD.get(i));
//		}	
//		out.print("</list>");
//	}	
	
	
    }
}
