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

public class Dataentry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String btn = request.getParameter("button");
		 
	            if ("addsupplier".equals(btn)) {
	                String supplierId = request.getParameter("snum");
	                String supplierName = request.getParameter("sname");
	                int status = Integer.parseInt(request.getParameter("sstatus"));
	                String location = request.getParameter("scity");

	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");
	                    String insertQuery = "INSERT INTO suppliers VALUES (?, ?, ?, ?)";
	                    try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
	                        pstmt.setString(1, supplierId);
	                        pstmt.setString(2, supplierName);
	                        pstmt.setInt(3, status);
	                        pstmt.setString(4, location);
	                        
	                        pstmt.executeUpdate();
	                    }

	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            if ("addparts".equals(btn)) {
	                String Id = request.getParameter("pnum");
	                String Name = request.getParameter("pname");
	                String color = request.getParameter("pcolor");
	                int weight = Integer.parseInt(request.getParameter("sweight"));
	                String location = request.getParameter("scity");

	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");
	                    String insertQuery = "INSERT INTO parts VALUES (?, ?, ?, ?,?)";
	                    try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
	                        pstmt.setString(1, Id);
	                        pstmt.setString(2, Name);
	                        pstmt.setString(3, color);
	                        pstmt.setInt(4, weight);
	                        pstmt.setString(5, location);
	                        
	                        pstmt.executeUpdate();
	                    }

	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            if ("addjob".equals(btn)) {
	                String Id = request.getParameter("jnum");
	                String Name = request.getParameter("jname");
	                int status = Integer.parseInt(request.getParameter("jnumworker"));
	                String location = request.getParameter("jcity");

	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");
	                    String insertQuery = "INSERT INTO jobs VALUES (?, ?, ?, ?)";
	                    try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
	                        pstmt.setString(1, Id);
	                        pstmt.setString(2, Name);
	                        pstmt.setInt(3, status);
	                        pstmt.setString(4, location);
	                        
	                        pstmt.executeUpdate();
	                    }

	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            if ("addshipment".equals(btn)) {
	                String Id1 = request.getParameter("ssnum");
	                String Id2 = request.getParameter("spnum");
	                String Id3 = request.getParameter("sjnum");
	                int qun = Integer.parseInt(request.getParameter("squantity"));
	                
	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");
	                    String insertQuery = "INSERT INTO shipments VALUES (?, ?, ?, ?)";
	                    try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
	                        pstmt.setString(1, Id1);
	                        pstmt.setString(2, Id2);
	                        pstmt.setString(3, Id3);
	                        pstmt.setInt(4, qun);
	                        
	                        pstmt.executeUpdate();
	                    }

	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            else {
		            request.setAttribute("select", "");
		            request.setAttribute("result", "");
		        }

	RequestDispatcher dispatcher = request.getRequestDispatcher("dataentryHome.jsp");
    dispatcher.forward(request, response);}}
