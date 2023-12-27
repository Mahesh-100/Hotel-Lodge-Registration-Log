

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String CheckIn=request.getParameter("checkInDate");
		String CheckOut=request.getParameter("checkOutDate");
		
		response.setContentType("text/html");
		PrintWriter A=response.getWriter();
		
		A.println(name+"<br>"+contact+"<br>"+email+"<br>"+CheckIn+"<br>"+CheckOut);
		
	}

}
