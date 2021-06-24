/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lenov
 */
@WebServlet(urlPatterns = {"/ConsultaDiputados"})
public class ConsultaDiputados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        Connection connect = null;
        Statement state = null;
        ResultSet rs = null;
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConsultaDiputados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/votaciones","root", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiputados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {  
            state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiputados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = state.executeQuery("SELECT C.nombre,sum(CC.votosCasilla) FROM casilla_has_candidatos CC INNER JOIN candidatos C ON C.idCandidato = CC.idCandidato WHERE C.distrito = '07' GROUP BY CC.idCandidato;");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiputados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {      
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Validacion</title>");  
                out.println("<link href=\"CSS/estilos.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<link href=\"CSS/CSS2.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("</head>");
                out.println("<body>"); 
                out.println("<nav>");
                        out.println("<ul>");
                            out.println("<li>");
                                out.println("<a href=\"Logout\" class=\"\">Cerrar sesion</a>");
                            out.println("</li>");
                            out.println("<li style=\"float:left\">");
                                out.println("<a href=\"http://localhost:8080/SistemaConteoDeVotos/Registro_Consulta.jsp\"><img src=\"IMAGENES/logo.png\" alt=\"Logo PREP\" width=\"30\" height=\"30\"></a>");
                              out.println("<li>");
                        out.println("</ul>");
                out.println("</nav>");
               out.println("<hr size=\"2px\" width=\"90%\" noshade=\"noshade\" align=\"center\"/>");
               out.println("<h1>Diputados</h1>");
                out.println("<table border='1'>");
                out.println("<th>");
                    out.println("Candidatos");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Votos");
                    out.println("</th>");
                out.println("</table'>");
            while(rs.next()){
                String nombre = rs.getString(1);
                String votos = rs.getString(2);                
                    out.println("<table border='2'>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(nombre);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(votos);
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDiputados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(connect != null){ 
                try{ 
                    connect.close(); 
                    state.close(); 
                    rs.close();
                } catch( SQLException e ) { 
                    System.out.println( e.getMessage()); 
                } 
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
