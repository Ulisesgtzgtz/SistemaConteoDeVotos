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
/**
 *
 * @author Ulisesgtz
 */
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
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
        boolean e;
        
        try {
            d.conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String ConfirmarContrasena = request.getParameter("confirmarContrasena");
        String domicilio = request.getParameter("domicilio");
        String colonia = request.getParameter("colonia");
        String codigoPostal = request.getParameter("codigoPostal");
        String municipio = request.getParameter("municipio");
        String telefono = request.getParameter("telefono");
        String tipoUsuario = "Capturista";
        
        try {
            e = d.isEmailRegistered(correo);
            if(e==true){
                response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/errorEmail.jsp");
            }
            else{
                if(contrasena.equals(ConfirmarContrasena)){
                    d.registerUser(nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, tipoUsuario);
                    response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
                }
                else{
                    response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/errorContrasena.jsp");
                }
            }
        } catch (SQLException ex) {
            System.out.println( ex.getMessage());
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

        //processRequest(request, response);
        //PrintWriter out = response.getWriter();
        //HttpSession respuesta = request.getSession(true);

/*String url = "jdbc:mysql://localhost:3307/votaciones";
        String usuario = "root";
        String contrasena1 = "12345";*/
        
        /*try{
            Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, contrasena1);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(con != null){
            out.println("Se ha establecido una conexión a la base de datos ");
        }*/

/*if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || ConfirmarContrasena.isEmpty() || domicilio.isEmpty() || colonia.isEmpty() || codigoPostal.isEmpty() || municipio.isEmpty() || telefono.isEmpty()){
            respuesta.setAttribute("error", "Hay campos vacios");
            
        } else {
                if(v.isUsernameOrPasswordValid(contrasena)){
                    if(contrasena.equals(ConfirmarContrasena)){
                        try {
                            try {
                                con = d.conectar();
                            } catch (SQLException | ClassNotFoundException ex) {
                                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                if(d.isEmailRegistered(correo)){
                                    respuesta.setAttribute("error", "Esta direccion de correo ya fue registrada");
                                } else {
                                    try {
                                        state = con.createStatement();
                                        state.executeUpdate("INSERT INTO usuarios (nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, redSocial, tipoUsuario, privilegios) VALUES ('"+nombre+"', '"+apellido+"', '"+correo+"', '"+contrasena+"', '"+domicilio+"', '"+colonia+"', '"+codigoPostal+"', '"+municipio+"', '"+telefono+"', '"+redSocial+"', '"+tipoUsuario+"')");
                                        response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
                                    } catch (SQLException e) {
                                        System.out.println( e.getMessage());
                                    }
                                    finally{
                                        if(con != null){
                                            try{
                                                con.close();
                                                state.close();
                                            } catch( SQLException e ) {
                                                System.out.println( e.getMessage());
                                            }
                                        }
                                   }
                                }
                            con.close();
                        } catch (Exception e) { out.println("Ocurrio la sig exception: " +e); }
                        
                        
                        
                    } else {
                        respuesta.setAttribute("error", "Las contraseñas no son iguales");
                        
                    }
                    
                } else {
                    respuesta.setAttribute("error", "Contraseña no es válida");
                   
                }

        }
        
        response.sendRedirect("register.jsp");*/
        
        /*try {
            state = con.createStatement();
            state.executeUpdate("INSERT INTO usuarios (nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, redSocial, tipoUsuario) VALUES ('"+nombre+"', '"+apellido+"', '"+correo+"', '"+contrasena+"', '"+domicilio+"', '"+colonia+"', '"+codigoPostal+"', '"+municipio+"', '"+telefono+"', '"+redSocial+"', '"+tipoUsuario+"')");
            response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }*/

/*try {
            d.registerUser(nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, redSocial, tipoUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        /*finally{
            try {
                if(d.conectar() != null){
                    try {
                        d.desconectar();
                        response.sendRedirect("http://localhost:8080/SistemaConteoDeVotos/login.jsp");
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/

        /*finally{
            if(con != null){
                try{
                con.close();
                state.close();
            } catch( SQLException e ) {
            System.out.println( e.getMessage());
            }
            }
        }*/