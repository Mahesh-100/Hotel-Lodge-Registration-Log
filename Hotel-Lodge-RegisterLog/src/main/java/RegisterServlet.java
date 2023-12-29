

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		// Retrieve form data from the request
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String checkInDate=request.getParameter("checkInDate");
		String checkOutDate=request.getParameter("checkOutDate");
		
		 // Process the form data (insert into database using JDBC)
        boolean success = insertFormData(name, contact, email, checkInDate, checkOutDate);
        
        // Send a response back to the client
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (success) {
            out.print("Form data received and inserted into the database successfully!");
        } else {
            out.print("Error processing form data.");
        }
        
    }
	 private boolean insertFormData(String name, String contact, String email, String checkInDate, String checkOutDate) {
	        // JDBC code to insert data into the MySQL database
	       
	        String DB_URL = "jdbc:mysql://localhost:3306/customers";
	        String DB_USER = "root";
	        String DB_PASSWORD = "89788";
	        

	        try  {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	            String sql = "INSERT INTO customers (name, contact, email, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?)";
	            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	                stmt.setString(1, name);
	                stmt.setString(2, contact);
	                stmt.setString(3, email);
	                stmt.setString(4, checkInDate);
	                stmt.setString(5, checkOutDate);

	                int rowsAffected = stmt.executeUpdate();
	                return rowsAffected > 0;
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}

		
		
	


