package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DB;

public class LogDataServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String temp = request.getParameter("temp");
        String hum = request.getParameter("hum");
        
        if ("".equals(temp)){
            temp = null;
        }
        
        if ("".equals(hum)){
            hum = null;
        }
        
        DB.init();
        Connection connection = null;
        Statement st = null;
        try {
            connection = DB.getConnection();
            st = connection.createStatement();
            String query = "INSERT INTO temp_hum(temp, hum) VALUES(" + Double.parseDouble(temp) + ", " + Double.parseDouble(hum) + ")";
            st.executeUpdate(query);
        } catch (SQLException | NumberFormatException | NullPointerException ex) {
            Logger.getLogger(LogDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(LogDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LogDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
