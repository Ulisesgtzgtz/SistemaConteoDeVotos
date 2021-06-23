

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Dao;
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
 * @author Ulisesgtz
 */
@WebServlet(name="Admin",urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String correo = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection connect = null;
        Statement state = null;
        ResultSet rs = null;
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/votaciones","root", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {  
            state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs = state.executeQuery("SELECT * FROM usuarios WHERE aceptado='no'");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            
            while(rs.next()){
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                correo = rs.getString(4);
                String domicilio = rs.getString(6);
                String colonia = rs.getString(7); 
                String codigoPostal = rs.getString(8);
                String municipio = rs.getString(9);
                String telefono = rs.getString(10);
                String tipousuario = rs.getString(11);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Validacion</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=\"http://localhost:8080/SistemaConteoDeVotos/Admin\" method=\"post\">");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td>");
                out.println(codigo);
                out.println("</td>");
                out.println("<td>");
                out.println(nombre);
                out.println("</td>");
                out.println("<td>");
                out.println(apellido);
                out.println("</td>");
                out.println("<td>");
                out.println(correo);
                out.println("</td>");
                out.println("<td>");
                out.println(domicilio);
                out.println("</td>");
                out.println("<td>");
                out.println(colonia);
                out.println("</td>");
                out.println("<td>");
                out.println(codigoPostal);
                out.println("</td>");
                out.println("<td>");
                out.println(municipio);
                out.println("</td>");
                out.println("<td>");
                out.println(telefono);
                out.println("</td>");
                out.println("<td>");
                out.println(tipousuario);
                out.println("</td>");
                out.println("<td>");
                    out.println("<input type = \"radio\" name = \"Q2\" value=\"Aceptar\">Aceptar");
                    out.println("<input type = \"radio\" name = \"Q2\" value=\"Rechazar\">Rechazar");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"submit\" value=\"Enviar\">");
                    out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
        
        Dao d = new Dao();
        String resp = request.getParameter("Q2");
        
        try {
            d.conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(resp.equals("Aceptar")){
            try {
                d.isAccountAceptada2(correo);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/Admin");
        }
        else{
            try {
                d.isAccountRechazada(correo);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/Admin");
        }
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
