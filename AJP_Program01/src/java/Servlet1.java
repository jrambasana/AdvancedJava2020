import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    out.println("<h1>Hello World</h1>");
    out.println("Today's Date is:" + new Date());
}
}
