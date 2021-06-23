/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ulisesgtz
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        Dao d = new Dao();
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String correoAdmin = "admin@admin.com";
        String contrasenaAdmin = "246810";
        boolean e;
        
        try {
            d.conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            e = d.isAcountExists(correo, contrasena);
            if(e==true){
                if(correo.equals(correoAdmin) && contrasena.equals(contrasenaAdmin)){
                    response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/Admin");
                }else{
                    response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/validacion.jsp");
                }
            }else{
                response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        finally{
            try {
                d.desconectar();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
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

/*try {
            state = con.createStatement(); 
            rs = state.executeQuery("SELECT * FROM usuarios WHERE correo='"+correo+"'");
            if(rs.next()){
                String correoBD = rs.getString("correo");
                String contrasenaBD = rs.getString("contrasena");
                if((contrasena.equals(contrasenaBD) && correo.equals(correoBD))){
                    response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/index.jsp");    
                }
            }
            response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }*/

/*try {
            String NombreUsuario = d.getNameByEmail(correo);
            respuesta.setAttribute("sessionNombre", NombreUsuario);
            respuesta.setAttribute("sessionCorreo", correo);
            response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/index.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }*/

/*finally{ 
            if(con != null){
                try{
                    con.close(); 
                    state.close(); 
                    rs.close();
                } catch( SQLException e ) {
                    System.out.println( e.getMessage()); 
                } 
            }
        }*/