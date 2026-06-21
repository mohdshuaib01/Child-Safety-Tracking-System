package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.Dbconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateIncidentServlet")
public class UpdateIncidentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String incidentIdStr = request.getParameter("incidentId");
        String status = request.getParameter("status");

        try {
            Connection con = Dbconnection.getConnection();
            
            
            String sql = "UPDATE incidents SET status = ? WHERE incident_id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, Integer.parseInt(incidentIdStr));
            
            int rowsUpdated = ps.executeUpdate();

            
            if (rowsUpdated > 0) {
                out.print("SUCCESS");
            } else {
                out.print("NOT_FOUND");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("Error: " + e.getMessage());
        }
    }
}