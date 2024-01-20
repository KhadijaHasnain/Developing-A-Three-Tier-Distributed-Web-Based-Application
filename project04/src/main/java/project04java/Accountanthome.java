package project04java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Accountanthome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("button");

        if ("clear".equals(btn)) {
        	request.setAttribute("select", "");
        } else {
        	String set = request.getParameter("select");
        	if ("maxStatus".equals(set)) {
        		try{  
            		Class.forName("com.mysql.jdbc.Driver");  
            		Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/project04","root","root");   
            		Statement stmt=con.createStatement();  
            		ResultSet rs=stmt.executeQuery("select max(status) as Maximum_Status_Of_All_Suppliers from suppliers;");  
            		while(rs.next())  
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            		 request.setAttribute("result", rs);
            		con.close();  
            		}catch(Exception e){ System.out.println(e);}
            }else if ("totalWeight".equals(set)) {
            	try{  
            		Class.forName("com.mysql.jdbc.Driver");  
            		Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/project04","root","root");   
            		Statement stmt=con.createStatement();  
            		ResultSet rs=stmt.executeQuery("select sum(weight) as Sum_Of_All_Part_Weights from parts;");  
            		while(rs.next())  
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            		request.setAttribute("result", rs);
            		con.close();  
            		}catch(Exception e){ System.out.println(e);}
            }else if ("numSuppliers".equals(set)) {
            	try{  
            		Class.forName("com.mysql.jdbc.Driver");  
            		Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/project04","root","root");   
            		Statement stmt=con.createStatement();  
            		ResultSet rs=stmt.executeQuery("select count(*) as The_Total_Number_Of_Shipments from shipments;");  
            		while(rs.next())  
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            		request.setAttribute("result", rs);
            		con.close();  
            		}catch(Exception e){ System.out.println(e);}
            }else if ("workersInfo".equals(set)) {
            	try{  
            		Class.forName("com.mysql.jdbc.Driver");  
            		Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/project04","root","root");   
            		Statement stmt=con.createStatement();  
            		ResultSet rs=stmt.executeQuery("select jname, numworkers from jobs where numworkers = (select max(numworkers) from jobs);");  
            		while(rs.next())  
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            		request.setAttribute("result", rs);
            		con.close();  
            		}catch(Exception e){ System.out.println(e);}
            }else{
            	try{  
            		Class.forName("com.mysql.jdbc.Driver");  
            		Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/project04","root","root");   
            		Statement stmt=con.createStatement();  
            		ResultSet rs=stmt.executeQuery("select sname, status from suppliers;");  
            		while(rs.next())  
            		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            		request.setAttribute("result", rs);
            		con.close();  
            		}catch(Exception e){ System.out.println(e);}
            }  
        		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("accountantHome.jsp");
        dispatcher.forward(request, response);}}