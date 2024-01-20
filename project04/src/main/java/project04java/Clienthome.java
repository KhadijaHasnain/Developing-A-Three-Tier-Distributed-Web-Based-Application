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

@WebServlet("/Clienthome")
public class Clienthome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String btn = request.getParameter("button");

        if ("execute".equals(btn)) {
            String userInput = request.getParameter("input");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project04", "root", "root");

                // Check if the query is a SELECT query
                if (isSelectQuery(userInput)) {
                    // Use prepared statement to prevent SQL injection
                    try (PreparedStatement pstmt = con.prepareStatement(userInput)) {
                        ResultSet resultSet = pstmt.executeQuery();

                        // Convert result set to HTML table
                        String resultData = convertResultSetToHtmlTable(resultSet);

                        // Set the result in the request attribute to be displayed in JSP
                        request.setAttribute("resultData", resultData);
                    }
                } else {
                    request.setAttribute("errorMessage", "You can only execute SELECT queries.");
                }

                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception, set error message or log it
            }
        } else if ("clearfrm".equals(btn)) {
            // Clear the form
            request.setAttribute("input", "");
            request.setAttribute("resultData", "");
            request.setAttribute("errorMessage", "");
        } else if ("clearrst".equals(btn)) {
            // Clear the result
            request.setAttribute("resultData", "");
            request.setAttribute("errorMessage", "");
        }

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientHome.jsp");
        dispatcher.forward(request, response);
    }

    private boolean isSelectQuery(String query) {
        // Simple check to see if the query starts with SELECT
        return query.trim().toUpperCase().startsWith("SELECT");
    }

    private String convertResultSetToHtmlTable(ResultSet resultSet) throws SQLException {
        // Convert result set to HTML table
        StringBuilder resultData = new StringBuilder("<table border='1'><tr>");
        int columnCount = resultSet.getMetaData().getColumnCount();

        // Create table headers
        for (int i = 1; i <= columnCount; i++) {
            resultData.append("<th>").append(resultSet.getMetaData().getColumnName(i)).append("</th>");
        }
        resultData.append("</tr>");

        // Fill table with data
        while (resultSet.next()) {
            resultData.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                resultData.append("<td>").append(resultSet.getString(i)).append("</td>");
            }
            resultData.append("</tr>");
        }
        resultData.append("</table>");

        return resultData.toString();
    }
}
